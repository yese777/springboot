package com.yese.service.impl;

import com.yese.service.AsyncService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * 异步任务
 */
@Service
public class AsyncServiceImpl implements AsyncService {

    // @Async:告诉Spring这是一个异步方法
    @Override
    @Async
    public void asyncTest() {
        System.out.println("处理数据开始...");
        try {
            // 此处模拟耗时的方法
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("处理数据结束...");
    }
}