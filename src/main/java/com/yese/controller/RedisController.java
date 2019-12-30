package com.yese.controller;

import com.yese.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 测试Redis
 */
@RestController
public class RedisController {
    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping("/redisTest")
    public Object test() {

        //先根据key去Redis中查
        Object o = redisTemplate.opsForValue().get("users");
        if (null == o) {//Redis没有,先去数据库查,查出来再放到Redis中(这里直接造数据)
            List<User> list = new ArrayList<>();
            User u1 = new User("1", "张三1", "123456");
            User u2 = new User("2", "张三2", "123456");
            User u3 = new User("3", "张三3", "123456");
            User u4 = new User("4", "张三4", "123456");
            list.add(u1);
            list.add(u2);
            list.add(u3);
            list.add(u4);

            //10秒过期
            redisTemplate.opsForValue().set("users", list, 10, TimeUnit.SECONDS);
            System.out.println("无");
            return list;

        } else {//有
            System.out.println("有");
            return o;
        }


    }
}
