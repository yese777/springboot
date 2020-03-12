package com.yese.config;

import com.yese.component.LoginHandlerInterceptor;
import com.yese.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    // 添加自定义的视图解析器,定制首页
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");// 输入/,跳login.html
        registry.addViewController("/index.html").setViewName("login");// 输入/index.html,跳login.html
        registry.addViewController("/main.html").setViewName("dashboard");
    }

    // 注册自定义的区域解析器
    @Bean
    public LocaleResolver localeResolver() {
        return new MyLocaleResolver();
    }

    // 注册登录拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        /**
         * 注册登录拦截器
         * addPathPatterns:/**:拦截所有请求
         * excludePathPatterns:排除哪些请求(登录不能拦截;静态资源文件不能拦截，否则样式显示不出来;放行druid 监控页面)
         */
        registry.addInterceptor(new LoginHandlerInterceptor())
                .addPathPatterns("/**").excludePathPatterns("/druid","/index.html", "/", "/user/login", "/asserts/**", "/webjars/**");
    }

}