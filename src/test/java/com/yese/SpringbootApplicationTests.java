package com.yese;

import com.yese.pojo.User;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class SpringbootApplicationTests {

    /**
     * 日志测试
     */
    // 记录器(注意都是slf4j包下的)
    Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    public void logTest() {
        //日志的级别；由低到高   trace<debug<info<warn<error
        //可以调整输出的日志级别；日志就只会在这个级别及以后的高级别生效
        logger.trace("这是trace日志...");
        logger.debug("这是debug日志...");
        //SpringBoot默认给我们使用的是info级别的，没有指定级别的就用SpringBoot默认规定的级别即root级别
        logger.info("这是info日志...");
        logger.warn("这是warn日志...");
        logger.error("这是error日志...");
    }

    //邮件测试开始-----------------------------------------------------------------------------------
    @Autowired
    JavaMailSenderImpl mailSender;

    //简单邮件
    @Test
    void test01() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("邮件标题");//标题
        message.setText("邮件内容");//内容
        message.setTo("15195988693@163.com");//发给谁,可变长参数
        message.setFrom("1321810135@qq.com");//谁发的
        mailSender.send(message);
    }

    //复杂邮件
    @Test
    void test02() throws MessagingException {

        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

        helper.setSubject("通知-今晚开会");
        //true:开启html
        helper.setText("<b style='color:red'>今天 7:30 开会</b>", true);
        helper.setTo("15195988693@163.com");
        helper.setFrom("1321810135@qq.com");

        //上传文件
        helper.addAttachment("1.jpg", new File("D:\\1.png"));
        helper.addAttachment("2.jpg", new File("D:\\2.png"));

        mailSender.send(mimeMessage);
    }
    //邮件测试结束-----------------------------------------------------------------------------------


    //RabbitMQ测试开始-----------------------------------------------------------------------------------
    @Autowired
    RabbitTemplate rabbitTemplate;

    //单播(点对点)发送消息
    @Test
    public void send01() {
        //object默认当成消息体,只需要传入要发送的对象,自动序列化发送给rabbitmq
        //rabbitTemplate.convertAndSend(exchange,routeKey,object);

        Map<String, Object> map = new HashMap<>();
        map.put("msg", "这是第一个消息");
        map.put("data", Arrays.asList("你好", 123, true));

        rabbitTemplate.convertAndSend("exchange.direct", "zhangsan.dog", map);
    }

    //接收消息,使用该方法获取到消息后队列里的消息就会自动清除。
    @Test
    public void receive01() {
        Object o = rabbitTemplate.receiveAndConvert("zhangsan.dog");
        System.out.println(o.getClass());
        System.out.println(o);
    }

    //广播模式只需要指定交换器的类型，自动会向该交换器绑定的所有队列发送消息。
    @Test
    public void send02() {
        //只需要指定fanout类型的交换器
        rabbitTemplate.convertAndSend("exchange.fanout", "", new User("1", "张三", "123"));
    }

    //发布/订阅(模糊匹配)方式,只需要指定交换器，修改对应的routingKey
    @Test
    public void send03() {
        rabbitTemplate.convertAndSend("exchange.topic", "*.dog", new User("2", "李四", "123"));
    }
    //RabbitMQ测试结束-----------------------------------------------------------------------------------

    @Test
    void contextLoads() {
    }

}
