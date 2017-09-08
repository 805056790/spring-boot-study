package per.study.jpa.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import per.study.jpa.model.JpaUser;
import per.study.jpa.service.JpaUserService;

import java.util.List;

/**
 * @author : panxin
 */
@RestController
public class JpaUserApis {

    private final JpaUserService userService;

    @Autowired
    public JpaUserApis(JpaUserService userService) {
        this.userService = userService;
    }

    @GetMapping("/api/user")
    public List<JpaUser> findAll() {
        return userService.findAll();
    }

    @GetMapping("/api/user/{id}")
    public JpaUser findById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @PostMapping("/api/user")
    public JpaUser create(@RequestParam String name) {
        return userService.create(JpaUser.builder().name(name).build());
    }

    @PutMapping("/api/user/{id}")
    public Boolean update(@PathVariable Long id,
                          @RequestParam String name) {
        return userService.update(id, name);
    }

}
