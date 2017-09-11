package pers.study.mybatis.api;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import pers.study.mybatis.BaseApiTest;
import pers.study.mybatis.model.User;

/**
 * @author : panxin
 */
public class UserApiTest extends BaseApiTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testFindById() {
        User user = restTemplate.getForObject("/api/user/{id}", User.class, 1);
        Assert.assertNotNull(user);
    }

}
