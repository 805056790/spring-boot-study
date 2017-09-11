package pers.study.jpa.service;

import com.google.common.base.Strings;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import pers.study.jpa.model.JpaUser;

import java.util.List;

/**
 * @author : panxin
 */
@Slf4j
@Service
public class JpaUserServiceImpl implements JpaUserService {

    private final JpaUserRepository userRepository;

    @Autowired
    public JpaUserServiceImpl(JpaUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public JpaUser findById(Long id) {
        log.info("try to find user by id = {}", id);
        return userRepository.findById(id);
    }

    @Override
    public List<JpaUser> findAll() {
        log.info("try to find all users");
        return userRepository.findAll();
    }

    @Override
    public JpaUser create(JpaUser user) {
        log.info("try to create user = {}", user);
        Assert.notNull(user, "User must not be null");
        return userRepository.save(user);
    }

    @Override
    public Boolean update(Long id, String name) {
        log.info("try to update user id = {}, name = {}", id, name);
        Assert.notNull(id, "User id must not be null");
        Assert.isTrue(!Strings.isNullOrEmpty(name), "User name must not be null or empty");
        return userRepository.update(id, name) == 1;
    }

}
