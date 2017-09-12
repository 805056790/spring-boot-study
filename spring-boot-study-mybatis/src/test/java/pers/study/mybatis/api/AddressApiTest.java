package pers.study.mybatis.api;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import pers.study.mybatis.BaseApiTest;
import pers.study.mybatis.model.Address;

import java.util.List;

/**
 * @author : panxin
 */
public class AddressApiTest extends BaseApiTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void findAll() {
        ResponseEntity<List<Address>> entity = restTemplate.exchange(
                "/api/addresses",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Address>>() {});
        List<Address> addresses = entity.getBody();
        Assert.assertNotNull(addresses);

        Assert.assertEquals(1, addresses.size());
    }

}
