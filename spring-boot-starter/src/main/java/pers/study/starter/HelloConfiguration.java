package pers.study.starter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

/**
 * @author panxin
 */
@ConditionalOnClass(HelloCondition.class)
@ConditionalOnProperty(prefix = "hello.test", name = "wtf")
@EnableConfigurationProperties({
        HelloProperty.class
})
public class HelloConfiguration {

    @Autowired
    private HelloProperty helloProperty;

    public HelloConfiguration() {
        System.out.println("hello is enable");
    }

    @Bean
    public HelloCondition helloCondition() {
        HelloCondition condition = new HelloCondition();
        condition.setName(helloProperty.getWtf());

        System.out.println(helloProperty);
        System.out.println(condition);
        return condition;
    }

}
