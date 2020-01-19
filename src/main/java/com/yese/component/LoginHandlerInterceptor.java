package com.yese.component;


import com.yese.pojo.User;
import com.yese.utils.ConstantUtil;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录拦截器
 */
public class LoginHandlerInterceptor implements HandlerInterceptor {

    @Override
    // 目标方法执行之前
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        User user = (User) request.getSession().getAttribute(ConstantUtil.LOGIN_USER);
        if (user == null) {// 未登录，返回登录页面
            request.setAttribute("msg", "没有权限，请先登录!");
            request.getRequestDispatcher("/index.html").forward(request, response);
            return false;
        } else {
            // 登录，放行
            return true;
        }
    }

}