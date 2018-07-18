package com.jiangshui.springbootpractic.practice.exception.exception_map;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xujiangshui
 * @Date on 2018/7/17 0017
 */
public class ExceptionMessage {
    public static  Map<String,String> exceptionMessage = new HashMap<String, String>();

    static {
        //处理用户异常信息
        exceptionMessage.put("user.login.password.password_not_correct","您输入的密码有误");
        exceptionMessage.put("user.login.username.no_sush_user","您输入的用户不存在");
    }
}
