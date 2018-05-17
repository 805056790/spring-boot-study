package pers.study.starter.koa;

import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.List;

/**
 * @author panxin
 */
@RequestMapping
@RestController
public class DemoApis {

    @GetMapping("/koa1")
    public String apiGet() {
        return "hello get api";
    }

    @GetMapping("/koa2")
    public String apiGetWithParams(@RequestParam String name) {
        return "hello: " + name;
    }

    @PostMapping("/koa")
    public String apiPost() {
        return "{id: 11, name: xiaopp}";
    }

    @PostMapping("/koa/{id}")
    public String apiPostWithParams(@PathVariable Long id, @RequestParam String name) {
        return "{id: " + id + ", name: " + name + "}";
    }

    @PostMapping("/koa/reg")
    public String apiPostWithParams(@RequestParam String name, @RequestParam String password) {
        return "{name: " + name + ", password: " + password + "}";
    }

    @GetMapping("/koa/users")
    public List<User> findUsers(@RequestParam(defaultValue = "1") Integer pageNo,
                                @RequestParam(defaultValue = "5") Integer pageSize) {
        Integer offset = (pageNo - 1) * pageSize + 1;
        Integer end = offset + pageSize;
        List<User> userList = Lists.newArrayList();

        for (; offset < end; offset++) {
            userList.add(new User((long) offset, "name_" + offset));
        }
        return userList;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class User implements Serializable {

        private static final long serialVersionUID = 8040554488990304168L;

        private Long id;

        private String name;

    }

}
