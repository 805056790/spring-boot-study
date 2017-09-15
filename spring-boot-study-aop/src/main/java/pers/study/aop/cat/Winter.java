package pers.study.aop.cat;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author : panxin
 */
@Aspect
@Component
public class Winter {

    @Pointcut("execution(** pers.study.aop.service.SeasonService.winter(..))")
    public void winter(){}

    @Before("winter()")
    public void before() {
        System.out.println("Winter is coming...");
    }

    @After("winter()")
    public void after() {
        System.out.println("Winter is coming to an end...");
    }

}
