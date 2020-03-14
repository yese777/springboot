package com.yese.controller;

import com.yese.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 异步任务
 */
@RestController
public class AsyncController {

    @Autowired
    private AsyncService asyncService;

    @GetMapping("/asyncTest")
    public String asyncTest() {
        //该方法可能比较耗时,但是想让用户很快获取到success
        asyncService.asyncTest();
        return "success";
    }

}