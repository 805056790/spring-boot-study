package pers.study.devtools;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 修改文件内容之后, recompile修改的文件或者rebuild工程即可生效
 *
 * @author : panxin
 */
@RestController
@SpringBootApplication
public class DevToolsApplication {

    @GetMapping("/")
    public String welcome() {
        return "Welcome";
    }

    @GetMapping("/login")
    public String hello() {
        return "Hello";
    }

    @GetMapping("/logout")
    public String goodbye() {
        return "Goodbye";
    }

    public static void main(String[] args) {
        SpringApplication.run(DevToolsApplication.class, args);
    }

}
