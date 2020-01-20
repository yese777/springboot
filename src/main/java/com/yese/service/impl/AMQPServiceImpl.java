package com.yese.service.impl;

import com.yese.pojo.User;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class AMQPServiceImpl {

    // 监听的队列,可以是数组,监听队列lisi.dog，只要收到消息，立刻执行该方法,并清空队列
    @RabbitListener(queues = "lisi.dog")
    public void receive01(User user) {
        System.out.println("接收到消息:" + user);
    }

    // 获取消息的所有信息
    @RabbitListener(queues = "zhangsan")
    public void receive02(Message message) {
        System.out.println("消息内容:" + message.getBody());
        System.out.println("消息头:" + message.getMessageProperties());
    }
}