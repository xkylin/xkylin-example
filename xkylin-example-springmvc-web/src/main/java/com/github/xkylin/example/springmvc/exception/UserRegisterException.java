package com.github.xkylin.example.springmvc.exception;

/**
 * 用户注册异常
 * @author Xkylin
 */
public class UserRegisterException extends Exception {

    public UserRegisterException(String message) {
        super(message);
    }

    public UserRegisterException(String message, Throwable cause) {
        super(message, cause);
    }
}
