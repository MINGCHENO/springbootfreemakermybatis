package com.eagle.ykm.service;

import com.eagle.ykm.model.User;
import com.eagle.ykm.utils.ConcurrentUtils;
import org.springframework.stereotype.Service;

/**
 * @description
 * @auth YKM
 * @date 2019/9/21 16:05
 **/
@Service
public class HostHolder {

    public User getUser() {
        return ConcurrentUtils.getHost();
    }

    public void setUser(User user) {
        ConcurrentUtils.setHost(user);
    }


}