package pers.study.devtools;

import lombok.Builder;
import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;

/**
 * @author : panxin
 */
@RestController
public class HelloDevTools {

    @GetMapping("/api/dev-tools")
    public String helloDevTools() {
        return "this is dev-tools";
    }

    @GetMapping("/api/tool")
    public Tools findTool() {
        return Tools.builder().name("spring-boot-devtools").code("001").build();
    }

    @Builder
    @Data
    public static class Tools implements Serializable {
        private static final long serialVersionUID = 2974548987674381664L;
        private String name;
        private String code;
    }

}
