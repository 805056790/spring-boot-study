package pers.study.jdbc.service;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import pers.study.jdbc.model.JdbcUser;

import java.util.List;

/**
 * @author : panxin
 */
@Slf4j
@Service
public class JdbcUserServiceImpl implements JdbcUserService {

    private final JdbcUserRepository userRepository;

    @Autowired
    public JdbcUserServiceImpl(JdbcUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public JdbcUser create(JdbcUser user) {
        Assert.notNull(user, "user must not be null");
        Assert.notNull(user.getName(), "name must not be null");
        Assert.notNull(user.getPassword(), "password must not be null");
        return userRepository.save(user);
    }

    @Override
    public Boolean update(Long id, String name, String password) {
        Assert.notNull(id, "id must not be null");
        Assert.notNull(name, "name must not be null");
        Assert.notNull(password, "password must not be null");
        return userRepository.update(id, name, password) == 1;
    }

    @Override
    public JdbcUser findById(Long id) {
        Assert.notNull(id, "id must not be null");
        return userRepository.findOne(id);
    }

    @Override
    public List<JdbcUser> findAll() {
        List<JdbcUser> userList = Lists.newArrayList();
        userRepository.findAll().forEach(userList::add);
        return userList;
    }
}
