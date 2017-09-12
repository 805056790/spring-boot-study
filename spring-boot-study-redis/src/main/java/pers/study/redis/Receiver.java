package pers.study.redis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.CountDownLatch;

/**
 * @author : panxin
 */
@Slf4j
public class Receiver {

    private final CountDownLatch latch;

    @Autowired
    public Receiver(CountDownLatch latch) {
        this.latch = latch;
    }

    public void receiveMessage(String message) {
        log.info("Received message = {}", message);
        latch.countDown();
    }

}
