package pers.study.jpa;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import pers.study.jpa.model.JpaUser;

import java.net.URI;
import java.util.List;

/**
 * @author : panxin
 */
public class JpaUserTest extends BaseTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testFindById() {
        JpaUser user = restTemplate.getForObject(URI.create("/api/user/1"), JpaUser.class);
        Assert.assertNotNull(user);
        Assert.assertEquals(user.getId().longValue(), 1L);
    }

    @Test
    public void testFindAll() {
        ResponseEntity<List<JpaUser>> entity = restTemplate.exchange(
                "/api/user",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<JpaUser>>() {});
        List<JpaUser> users = entity.getBody();

        Assert.assertNotNull(users);

        // 这里jpa会读取import.sql 和 data.sql的内容, 所以是6
        // 还有就是data.sql内容不能空, 如果文件没有内容会报错
        Assert.assertEquals(6, users.size());
    }

    @Test
    public void testCreate() {
        JpaUser user = restTemplate.postForObject(URI.create("/api/user?name=Fish"), null, JpaUser.class);
        Assert.assertNotNull(user);
        Assert.assertEquals(7, user.getId().intValue());
    }

    @Test
    public void testUpdate() {
        restTemplate.put("/api/user/1?name=update_id_is_1", null);

        JpaUser user = restTemplate.getForObject(URI.create("/api/user/1"), JpaUser.class);
        Assert.assertNotNull(user);
        Assert.assertEquals(user.getName(), "update_id_is_1");
    }

}
