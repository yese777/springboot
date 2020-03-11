package com.yese.controller;

import com.yese.pojo.User;
import com.yese.service.UserService;
import com.yese.utils.ConstantUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    /**
     * 用户登录
     *
     * @RequestParam：将请求参数绑定到控制器的方法参数上（是springmvc中接收普通参数的注解）
     * 语法： @RequestParam(value="参数名",required="true/false",defaultValue="")
     * value：参数名
     * required：是否包含该参数，默认为true，表示该请求路径中必须包含该参数，如果不包含就报错。
     * defaultValue：默认参数值，如果设置了该值，required=true将失效，自动为false,如果没有传该参数，就使用默认值
     *
     * @param username 用户名
     * @param password 密码
     * @param model
     * @param session
     * @return
     */
    @PostMapping("/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Model model, HttpSession session) {

        User user = userService.getUserByUsernameAndPwd(username, password);

        if (null != user) {
            // 登录成功！存放session
            session.setAttribute(ConstantUtil.LOGIN_USER, user);
            // 防止表单重复提交，重定向
            return "redirect:/main.html";
        } else {
            // 登录失败！存放错误信息
            model.addAttribute("msg", "用户名密码错误!");
            return "login";
        }
    }

    // 登出
    @GetMapping("/user/loginOut")
    public String loginOut(HttpSession session) {
        // 清除session
        session.invalidate();
        return "redirect:/index.html";
    }

}