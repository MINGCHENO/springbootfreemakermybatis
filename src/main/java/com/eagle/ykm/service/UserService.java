package com.eagle.ykm.service;

import com.eagle.ykm.dao.UserDAO;
import com.eagle.ykm.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description
 * @auth YKM
 * @date 2019/9/20 18:40
 **/
@Service
public class UserService {

    @Autowired
    private UserDAO userDAO;

    public int addUser(User user) {
        return userDAO.addUser(user);
    }

    public User getUser(String email) {
        return userDAO.selectByEmail(email);
    }

    public User getUser(int uid) {
        return userDAO.selectById(uid);
    }



}