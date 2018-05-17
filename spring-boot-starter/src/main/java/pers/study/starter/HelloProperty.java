package pers.study.starter;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author panxin
 */
@Data
@ConfigurationProperties(prefix = "hello.test")
public class HelloProperty {

    private String wtf;

}
