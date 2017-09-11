package pers.study.mybatis.dao;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pers.study.mybatis.BaseDaoTest;
import pers.study.mybatis.model.User;

/**
 * @author : panxin
 */
public class UserDaoTest extends BaseDaoTest {

    @Autowired
    private UserDao userDao;

    private User user;

    @Before
    public void before() {
        user = User.builder().name("panxin").password("123456").build();
        userDao.create(user);

        Assert.assertNotNull(user.getId());
    }

    @Test
    public void testFindById() {
        User found = userDao.findById(user.getId());
        Assert.assertNotNull(found);
    }

    @Test
    public void testUpdate() {
        // find
        User found = userDao.findById(user.getId());
        Assert.assertNotNull(found);

        // update
        found.setPassword("654321");
        userDao.update(found);

        // find and check if updated
        User updated = userDao.findById(found.getId());
        Assert.assertEquals(found.getPassword(), updated.getPassword());
    }

}
