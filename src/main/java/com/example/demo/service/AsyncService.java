package com.example.demo.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

/**
 * @author 张彦培
 * @date 2021/5/1415:27
 */
@Service
public class AsyncService {
    @Async
    public Future<String> async1() throws InterruptedException {
        long time = System.currentTimeMillis();
        Thread.sleep(1000);
        System.out.println("async1耗时：" + (System.currentTimeMillis() - time) + "");
        return new AsyncResult<String>("async1");
    }

    @Async
    public Future<String> async2() throws InterruptedException {
        long time = System.currentTimeMillis();
        Thread.sleep(2000);
        System.out.println("async2耗时：" + (System.currentTimeMillis() - time) + "");
        return new AsyncResult<String>("async2");
    }

    @Async
    public Future<String> async3() throws InterruptedException {
        System.out.println("async3耗时:0000");
        long time = System.currentTimeMillis();
        Thread.sleep(3000);
        System.out.println("async3耗时：" + (System.currentTimeMillis() - time) + "");
        return new AsyncResult<String>("async3");
    }
}
