package com.yese.service.impl;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * 异步任务测试
 */
@Service
public class AsyncServiceImpl {

    //告诉Spring这是一个异步方法
    @Async
    public void asyncTest() {
        try {
            //此处模拟耗时的方法
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("处理数据中...");
    }
}