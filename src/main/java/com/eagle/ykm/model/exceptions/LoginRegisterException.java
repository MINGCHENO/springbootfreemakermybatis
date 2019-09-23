package com.eagle.ykm.model.exceptions;

/**
 * @description
 * @auth YKM
 * @date 2019/9/21 9:27
 **/
public class LoginRegisterException extends RuntimeException{
    public LoginRegisterException() {
        super();
    }

    public LoginRegisterException(String message) {
        super(message);
    }

    public LoginRegisterException(String message, Throwable cause) {
        super(message, cause);
    }

    public LoginRegisterException(Throwable cause) {
        super(cause);
    }


}