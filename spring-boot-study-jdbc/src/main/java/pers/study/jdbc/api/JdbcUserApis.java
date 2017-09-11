package pers.study.jdbc.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pers.study.jdbc.model.JdbcUser;
import pers.study.jdbc.service.JdbcUserService;

import java.util.List;

/**
 * @author : panxin
 */
@RestController
public class JdbcUserApis {

    private final JdbcUserService userService;

    @Autowired
    public JdbcUserApis(JdbcUserService userService) {
        this.userService = userService;
    }

    @GetMapping("/api/user")
    public List<JdbcUser> findAll() {
        return userService.findAll();
    }

    @GetMapping("/api/user/{id}")
    public JdbcUser findById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @PostMapping("/api/user")
    public JdbcUser create(@RequestParam String name,
                           @RequestParam String password) {
        return userService.create(JdbcUser.builder().name(name).password(password).build());
    }

    @PutMapping("/api/user/{id}")
    public Boolean update(@PathVariable Long id,
                          @RequestParam String name,
                          @RequestParam String password) {
        return userService.update(id, name, password);
    }

}
