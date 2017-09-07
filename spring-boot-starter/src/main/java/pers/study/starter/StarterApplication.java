package pers.study.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author : panxin
 */
@SpringBootApplication
public class StarterApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(StarterApplication.class);
        application.run(args);
    }

}
