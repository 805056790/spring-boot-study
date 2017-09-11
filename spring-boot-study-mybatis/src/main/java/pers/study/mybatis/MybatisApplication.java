package pers.study.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pers.study.mybatis.dao.UserDao;
import pers.study.mybatis.model.User;

/**
 * @author : panxin
 */
@RestController
@SpringBootApplication
public class MybatisApplication {

    @Autowired
    private UserDao userDao;

    @GetMapping("/api/user/{id}")
    public User findById(@PathVariable Long id) {
        return userDao.findById(id);
    }

    public static void main(String[] args) {
        SpringApplication.run(MybatisApplication.class, args);
    }

}
