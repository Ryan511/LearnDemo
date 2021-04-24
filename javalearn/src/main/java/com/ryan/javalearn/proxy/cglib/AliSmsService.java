package com.ryan.javalearn.proxy.cglib;

/**
 * @author zhongziqi
 * @date :2021/4/24 16:10
 * Desc:
 */
public class AliSmsService {
    public String send(String message) {
        System.out.println("send message:" + message);
        return message;
    }
}
