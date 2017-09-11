package pers.study.jdbc.api;

import com.google.common.collect.Maps;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import pers.study.jdbc.BaseTest;
import pers.study.jdbc.model.JdbcUser;

import java.util.Map;

/**
 * @author : panxin
 */
public class JdbcUserApiTest extends BaseTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testCreate() {
        JdbcUser user = restTemplate.postForObject("/api/user?name=user_1&password=pwd_123", null, JdbcUser.class);

        Assert.assertNotNull(user);
        Assert.assertEquals(1, (long) user.getId());
    }

    @Test
    public void testCreate_v2() {
        Map<String, Object> params = Maps.newHashMap();
        params.put("name", "user_hello");
        params.put("password", "password_hello");

        JdbcUser user = postFormForObject("/api/user", params, JdbcUser.class);
        Assert.assertNotNull(user);
        Assert.assertEquals(1, (long) user.getId());
    }

    private <T> ResponseEntity<T> postFormForEntity(String url, Map<String, Object> form, Class<T> responseType) {
        MultiValueMap<String, Object> params = new LinkedMultiValueMap<>(form.size());
        params.setAll(form);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.MULTIPART_FORM_DATA);

        HttpEntity<MultiValueMap<String, Object>> entity = new HttpEntity<>(params, httpHeaders);
        return restTemplate.exchange(url, HttpMethod.POST, entity, responseType);
    }

    private <T> T postFormForObject(String url, Map<String, Object> form, Class<T> responseType) {
        ResponseEntity<T> response = postFormForEntity(url, form, responseType);
        return response.getBody();
    }

}
