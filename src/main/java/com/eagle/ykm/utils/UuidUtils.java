package com.eagle.ykm.utils;

import java.util.UUID;

/**
 * @description
 * @auth YKM
 * @date 2019/9/20 19:14
 **/
public class UuidUtils {
    public static String next() {
        return UUID.randomUUID().toString().replace("-", "a");
    }
}