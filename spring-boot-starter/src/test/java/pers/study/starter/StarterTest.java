package pers.study.starter;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import pers.study.starter.api.HelloApis;

/**
 * @author : panxin
 */
public class StarterTest extends BaseTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testString() {
        String resp = restTemplate.getForObject("/api/hello", String.class);
        Assert.assertNotNull(resp);
    }

    @Test
    public void testObject() {
        HelloApis.Hello hello = restTemplate.getForObject(
                "/api/say-hello/{name}"
                , HelloApis.Hello.class
                , "panxin");
        Assert.assertNotNull(hello);
    }

}
