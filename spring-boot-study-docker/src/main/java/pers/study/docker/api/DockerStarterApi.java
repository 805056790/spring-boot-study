package pers.study.docker.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author panxin
 */
@RestController
public class DockerStarterApi {

    @GetMapping("/api/docker/hello")
    public String hello() {
        return "hello docker";
    }

}
