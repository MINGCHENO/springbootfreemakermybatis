package com.eagle.ykm.biz;

import com.eagle.ykm.model.User;
import com.eagle.ykm.service.TicketService;
import com.eagle.ykm.service.UserService;
import com.eagle.ykm.utils.MD5;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.security.auth.login.LoginException;

/**
 * @description
 * @auth YKM
 * @date 2019/9/20 21:24
 **/
@Service
public class LoginBiz {

    @Autowired
    private UserService userService;

    @Autowired
    private TicketService ticketService;

    public String login(String email, String password) {
        User user = userService.getUser(email);

        try {
            if (user == null) {
                throw new LoginException("邮箱不正确");
            }
            if (!StringUtils.equals(user.getPassword(),MD5.next(password))) {
                throw new LoginException("密码不正确");
            }
        } catch (LoginException e) {
            e.printStackTrace();
        }


        return "index";
    }

    /* 退出登录,删除session
     * @Param: [t]
     * @Author: Administrator
     * @Time 20:14
     * @return: void
     **/
    public void logout(String t) {
        ticketService.deleteTicket(t);
    }

   /* public String register(User user) {

        *//*检查email是是否为空,
        * 对*//*


    }*/


}