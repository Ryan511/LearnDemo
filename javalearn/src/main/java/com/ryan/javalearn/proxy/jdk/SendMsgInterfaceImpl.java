package com.ryan.javalearn.proxy.jdk;

/**
 * @author zhongziqi
 * @date :2021/4/24 15:54
 * Desc:
 */
public class SendMsgInterfaceImpl implements ISendMsgInterface {
    @Override
    public String sendMsg(String msg) {
        System.out.println("msg = " + msg);
        return msg;
    }
}
