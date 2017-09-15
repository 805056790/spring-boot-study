package pers.study.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import pers.study.aop.service.SeasonService;

/**
 * @author : panxin
 */
@EnableAspectJAutoProxy
@SpringBootApplication
public class AopApplication implements CommandLineRunner {

    @Autowired
    private SeasonService seasonService;

    public static void main(String[] args) {
        SpringApplication.run(AopApplication.class, args).close();
    }

    @Override
    public void run(String... strings) throws Exception {
        seasonService.hello("Spring boot aop");
        seeTheSpring();
        seeTheSummer();
        seeTheAutumn();
        seeTheWinter();
    }

    private void seeTheSpring() {
        seasonService.spring();
    }

    private void seeTheSummer() {
        seasonService.summer();
    }

    private void seeTheAutumn() {
        seasonService.autumn();
    }

    private void seeTheWinter() {
        seasonService.winter();
    }

}
