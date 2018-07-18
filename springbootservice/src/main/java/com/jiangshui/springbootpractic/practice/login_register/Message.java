package com.jiangshui.springbootpractic.practice.login_register;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xujiangshui
 * @Date on 2018/7/17 0017
 */


/**
 * 返回消息是否成功，返回消息的结果
 * 使用object，是因为结果类型不确定，可以是任何类型
 */
public class Message {

    public static Map<String,String> OK = new HashMap<String,String>();
    public static Map<String,String> FAIL = new HashMap<String,String>();
    public static Map<String,Object> RESULT = new HashMap<String,Object>();
    static {
        OK.put("result","success");
        FAIL.put("result","fail");
    }
}
