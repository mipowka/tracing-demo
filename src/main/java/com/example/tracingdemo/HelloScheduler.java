package com.example.tracingdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class HelloScheduler {

    private final HelloService helloService;
    private final Logger log = LoggerFactory.getLogger(HelloScheduler.class);

    public HelloScheduler(HelloService helloService) {
        this.helloService = helloService;
    }

    @Scheduled(fixedRate = 5000)
    public void hello() {
        log.info("hello start");
        System.out.println(helloService.hello());
        log.info("hello end");
    }
}
