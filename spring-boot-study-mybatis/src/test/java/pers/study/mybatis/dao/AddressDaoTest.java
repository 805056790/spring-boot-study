package pers.study.mybatis.dao;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pers.study.mybatis.BaseDaoTest;
import pers.study.mybatis.model.Address;

/**
 * @author : panxin
 */
public class AddressDaoTest extends BaseDaoTest {

    @Autowired
    private AddressDao addressDao;

    private Address address;

    @Before
    public void before() {
        address = Address.builder().name("ShangHai").code("330100").build();
        addressDao.create(address);

        Assert.assertNotNull(address.getId());
    }

    @Test
    public void testFindById() {
        Address found = addressDao.findById(address.getId());
        Assert.assertNotNull(found);
    }

    @Test
    public void testUpdate() {
        // find
        Address found = addressDao.findById(address.getId());
        Assert.assertNotNull(found);

        // update
        found.setCode("123456");
        addressDao.update(found);

        // find and check if updated
        Address updated = addressDao.findById(found.getId());
        Assert.assertEquals(found.getCode(), updated.getCode());
    }

}
