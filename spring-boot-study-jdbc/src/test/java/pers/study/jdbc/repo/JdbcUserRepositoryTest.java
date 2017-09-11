package pers.study.jdbc.repo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pers.study.jdbc.BaseTest;
import pers.study.jdbc.model.JdbcUser;
import pers.study.jdbc.service.JdbcUserRepository;

/**
 * @author : panxin
 */
public class JdbcUserRepositoryTest extends BaseTest {

    @Autowired
    private JdbcUserRepository userRepository;

    private JdbcUser user;

    @Before
    public void testBefore() {
        user = JdbcUser.builder().name("test_user").password("123456").build();
        userRepository.save(user);
        Assert.assertNotNull(user.getId());
    }

    @Test
    public void testFindAll() {
        Iterable<JdbcUser> users = userRepository.findAll();
        long actual = users.spliterator().estimateSize();
        Assert.assertEquals(1, actual);
    }

    @Test
    public void testUpdate() {
        int updated = userRepository.update(user.getId(), "updated_name", "updated_password");
        Assert.assertEquals(1, updated);
    }

    @Test
    public void testFindById() {
        JdbcUser found = userRepository.findOne(user.getId());
        Assert.assertEquals(found.getId(), user.getId());
    }

}
