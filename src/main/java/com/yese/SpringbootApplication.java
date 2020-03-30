package com.yese;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling//开启定时任务注解
@EnableAsync//开启异步任务注解
@EnableRabbit//开启基于注解的RabbitMQ
@MapperScan("com.yese.mapper")//扫描mapper包
/**
 *  @SpringBootApplication :用来标注一个主配置类，说明这是一个Spring Boot应用
 *  这个类只能和 controller,service,dao 这些包同级,约定大于配置!
 */
@SpringBootApplication
public class SpringbootApplication {

    public static void main(String[] args) {
        /**
         * Springboot整合Elasticsearch 在项目启动前设置一下的属性，防止报错
         * 解决netty冲突后初始化client时还会抛出异常
         * java.lang.IllegalStateException: availableProcessors is already set to [4], rejecting [4]
         */
        System.setProperty("es.set.netty.runtime.available.processors", "false");
        SpringApplication.run(SpringbootApplication.class, args);
    }

}