package pers.study.redis;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

/**
 * @author : panxin
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ComponentScan("pers.study.redis")
public class RedisTest {

    private static final Log log = LogFactory.getLog(RedisTest.class);

    @Autowired
    private StringRedisTemplate redisTemplate;
    @Autowired
    private RedisTemplate<String, User> userRedisTemplate;

    @Test
    public void test() throws InterruptedException {
        String key = "game_of_the_thrones";
        String value = "winter is coming";

        log.info("[REDIS-TEST] try to save key = " + key + ", value = " + value);
        redisTemplate.opsForValue().set(key, value);
        String found = redisTemplate.opsForValue().get(key);

        Assert.assertEquals(value, found);

        log.info("[REDIS-TEST] try to set key expire in 3 seconds");
        redisTemplate.expire(key, 3, TimeUnit.SECONDS);
        Thread.sleep(3000);

        found = redisTemplate.opsForValue().get(key);
        log.info("[REDIS-TEST] try to find key = " + key + " after 3 seconds, found value is [" + found + "]");

        Assert.assertNull(found);
    }

    @Test
    public void testUser() {
        User jonSnow = User.builder().id(1L).name("JonSnow").description("bastard").build();
        User khaleesi = User.builder().id(2L).name("Khaleesi").description("mother of the dragons").build();

        userRedisTemplate.opsForValue().set(jonSnow.getName(), jonSnow);
        userRedisTemplate.opsForValue().set(khaleesi.getName(), khaleesi);

        User king = userRedisTemplate.opsForValue().get(jonSnow.getName());
        User queen = userRedisTemplate.opsForValue().get(khaleesi.getName());

        Assert.assertNotNull(king);
        Assert.assertNotNull(queen);

        Assert.assertEquals(jonSnow.getId(), king.getId());
        Assert.assertEquals(khaleesi.getId(), queen.getId());

        userRedisTemplate.delete(king.getName());
        userRedisTemplate.delete(queen.getName());
    }

}
