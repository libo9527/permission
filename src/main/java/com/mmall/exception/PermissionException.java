package com.mmall.exception;

/**
 * @Description：
 * @Auther： libo
 * @date： 2018/11/21:09:55
 */
public class PermissionException extends RuntimeException{
    public PermissionException() {
        super();
    }

    public PermissionException(String message) {
        super(message);
    }
}
