package pers.study.starter;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

/**
 * @author panxin
 */
@Component
public class HelloCondition {

    @Setter
    @Getter
    private String name;

    public HelloCondition() {
        System.out.println("hello condition");
    }

}
