package com.eagle.ykm.controllers;

import com.eagle.ykm.biz.LoginBiz;
import com.eagle.ykm.service.UserService;
import com.eagle.ykm.utils.CookieUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

/**
 * @description
 * @auth YKM
 * @date 2019/9/20 18:39
 **/
@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private LoginBiz loginBiz;

    /*
     * @Param: []
     * @Author: Administrator
     * @Time 9:40
     * @return: java.lang.String
     **/

    @RequestMapping(path = {"/users/login"}, method = {RequestMethod.GET})
    public String login() {
        System.out.println("这里算进来了?");
        return "login/login";

    }

    @RequestMapping(path = {"/users/login/doLogin"}, method = {RequestMethod.POST})
    public String doLogin(Model model, HttpServletResponse response,
                          @RequestParam("email") String email,
                          @RequestParam("password") String password){
        try {
            System.out.println("能进来吗?");
            /*注意: 在调用方法数据传输正确时,idea会提示完整的变量形式,形如: email:"email",password:"password"*/
            /*当然引号前面部分是不可见的*/
            String t = loginBiz.login("email", "password");
            System.out.println("进来了");
            /*这里的value包含email,password数据*/
            CookieUtils.writeCookie("t",t,response);
            /*登录成功,重定向到index*/
            return "redirect:/index";
        } catch (Exception e) {
            /*登录异常*/
            model.addAttribute("error", e.getMessage());
            return "404";
        }


    }


    /*@RequestMapping(path = {"/users/logout/do"}, method = {RequestMethod.GET})
    public String doLogout(@CookieValue("t") String t) {
        loginBiz.
    }*/
}