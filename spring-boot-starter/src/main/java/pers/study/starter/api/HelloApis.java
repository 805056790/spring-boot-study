package pers.study.starter.api;

import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : panxin
 */
@Slf4j
@RestController
public class HelloApis {

    @GetMapping("/")
    public String tips() {
        return "find your api mapping specifically. eg. /api/hello";
    }

    @GetMapping("/api/hello")
    public String hello() {
        return "Hello spring-boot!";
    }

    @GetMapping("/api/say-hello/{name}")
    public Hello sayHello(@PathVariable String name) {
        return Hello.builder().name(name).saySth("Hello!").build();
    }

    @Builder
    @Data
    public static class Hello {
        private String name;
        private String saySth;
    }

}
