package pers.study.aop.service;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 * @author : panxin
 */
@Service
public class SeasonServiceImpl implements SeasonService {

    @Override
    public void hello(String name) {
        Assert.notNull(name, "name must not be null");
        System.out.println("Hello " + name);
    }

    @Override
    public void spring() {
        System.out.println("Flowers come out...");
    }

    @Override
    public void summer() {
        System.out.println("Swimming is cool...");
    }

    @Override
    public void autumn() {
        System.out.println("Travel is better...");
    }

    @Override
    public void winter() {
        System.out.println("Snowing, you are beautiful in white...");
    }
}
