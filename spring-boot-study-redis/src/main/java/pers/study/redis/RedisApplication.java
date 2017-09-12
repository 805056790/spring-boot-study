package pers.study.redis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.util.concurrent.CountDownLatch;

/**
 * @author : panxin
 */
@Slf4j
@SpringBootApplication
public class RedisApplication {

    @Bean
    public RedisMessageListenerContainer redisMessageListenerContainer(RedisConnectionFactory redisConnectionFactory,
                                                                       MessageListenerAdapter messageListenerAdapter) {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(redisConnectionFactory);
        container.addMessageListener(messageListenerAdapter, new PatternTopic("Chat.*"));
        return container;
    }

    @Bean
    public MessageListenerAdapter messageListenerAdapter(Receiver receiver) {
        return new MessageListenerAdapter(receiver, "receiveMessage");
    }

    @Bean
    public Receiver receiver(CountDownLatch latch) {
        return new Receiver(latch);
    }

    @Bean
    public CountDownLatch countDownLatch() {
        return new CountDownLatch(1);
    }

    @Bean
    public StringRedisTemplate stringRedisTemplate(RedisConnectionFactory factory) {
        return new StringRedisTemplate(factory);
    }

    @Bean
    public RedisTemplate<String, User> redisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<String, User> redisTemplate = new RedisTemplate<>();

        redisTemplate.setConnectionFactory(factory);
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashValueSerializer(new RedisObjectSerializer());

        return redisTemplate;
    }

    public static void main(String[] args) throws InterruptedException {
        ApplicationContext context = SpringApplication.run(RedisApplication.class, args);

        StringRedisTemplate redisTemplate = context.getBean(StringRedisTemplate.class);

        CountDownLatch latch = context.getBean(CountDownLatch.class);

        log.info("Sending message...");
        redisTemplate.convertAndSend("Chat.game_of_the_thrones", "Hello Ned Stark!");

        latch.await();
        System.exit(0);
    }

}
