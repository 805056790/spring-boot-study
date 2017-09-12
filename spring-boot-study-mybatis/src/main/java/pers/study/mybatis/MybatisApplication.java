package pers.study.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pers.study.mybatis.dao.AddressDao;
import pers.study.mybatis.dao.UserDao;
import pers.study.mybatis.model.Address;
import pers.study.mybatis.model.User;

import java.util.List;

/**
 * @author : panxin
 */
@RestController
@SpringBootApplication
public class MybatisApplication {

    @Autowired
    private UserDao userDao;
    @Autowired
    private AddressDao addressDao;

    @GetMapping("/api/user/{id}")
    public User findById(@PathVariable Long id) {
        return userDao.findById(id);
    }

    @GetMapping("/api/addresses")
    public List<Address> findById() {
        return addressDao.findAll();
    }

    public static void main(String[] args) {
        SpringApplication.run(MybatisApplication.class, args);
    }

}
