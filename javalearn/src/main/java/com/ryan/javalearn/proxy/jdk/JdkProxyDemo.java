package com.ryan.javalearn.proxy.jdk;

/**
 * @author zhongziqi
 * @date :2021/4/24 15:53
 * Desc:
 */
public class JdkProxyDemo {
    public static void main(String[] args) {
        ISendMsgInterface smsService = (ISendMsgInterface) JdkProxyFactory.getProxy(new SendMsgInterfaceImpl());
        smsService.sendMsg("java");
        System.out.println("smsService = " + smsService);
    }
}
