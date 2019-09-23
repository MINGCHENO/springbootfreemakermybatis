package com.eagle.ykm.utils;

import com.eagle.ykm.model.User;

/**
 * @description
 * @auth YKM
 * @date 2019/9/21 16:06
 **/
public class ConcurrentUtils {
    private static ThreadLocal<User> host = new ThreadLocal<User>();

    public static User getHost() {
        return host.get();
    }

    public static void setHost(User user) {
        host.set(user);
    }


}