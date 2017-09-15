package pers.study.aop.cat;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author : panxin
 */
@Aspect
@Component
public class Hello {

    @Pointcut("execution(* pers.study.aop.service.SeasonService.hello(..)) && args(name)")
    public void sayHello(String name) {}

    @Before("sayHello(name)")
    public void before(String name) {
        System.out.println("Hello Aspect args = " + name);
    }

}
