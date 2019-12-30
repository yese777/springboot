package com.yese.controller;

import com.yese.service.impl.AsyncServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 异步任务测试
 */
@RestController
public class AsyncController {

    @Autowired
    AsyncServiceImpl asyncServiceImpl;

    @GetMapping("/asyncTest")
    public String asyncTest() {
        //该方法可能比较耗时,但是想让用户很快获取到success
        asyncServiceImpl.asyncTest();
        return "success";
    }
}