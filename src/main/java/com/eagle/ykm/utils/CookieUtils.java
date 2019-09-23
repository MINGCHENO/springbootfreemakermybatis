package com.eagle.ykm.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @description
 * @auth YKM
 * @date 2019/9/21 9:50
 **/
public class CookieUtils {
    private static int COOKIE_AGE = 60 * 60 * 24 * 7;

    public static void writeCookie(String key, String value, HttpServletResponse response) {
        Cookie cookie = new Cookie(key, value);
        cookie.setPath("/");
        cookie.setMaxAge(COOKIE_AGE);
//        设置好cookie,返回给response对象
        response.addCookie(cookie);
    }


    public static String getCookie(String key, HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(key)) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }

    /* 移除cookie,户名思议就是将cookie的maxAge设置为0,cookie的value设置为空,然后在返回给response对象
     * @Param:
     * @Author: Administrator
     * @Time 10:17
     * @return:
    **/
    public static void removeCookie(String key, HttpServletRequest request,
                                    HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        /*同一个cookie,key  和  name 必须相等 */
        /*一般cookie忽视大小写,但这里还是判断下*/
        for (int i = 0; i <(cookies == null ? 0 : cookies.length); i++) {
            if ((key).equalsIgnoreCase(cookies[i].getName())) {
                Cookie cookie = new Cookie(key, "");
                cookie.setPath("/");
                cookie.setMaxAge(0);
                response.addCookie(cookie);
            }
        }

    }

}