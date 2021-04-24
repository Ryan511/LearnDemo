package com.ryan.javalearn.proxy.cglib;

/**
 * @author zhongziqi
 * @date :2021/4/24 16:13
 * Desc:
 */
public class CglibDemoTest {
    public static void main(String[] args) {
        AliSmsService aliSmsService = (AliSmsService) CglibProxyFactory.getProxy(AliSmsService.class);
        aliSmsService.send("java");
    }
}
