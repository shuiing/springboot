package com.jiangshui.springbootpractic.practice.sms;

import java.util.HashMap;

/**
 * Created by TJJ on 16/09/14.
 */
public class SmsMessage {


    public static HashMap<String,String> RESULT = new HashMap<String, String>();

    static {
        RESULT.put("100","发送成功");
        RESULT.put("101","验证失败");
        RESULT.put("102","短信不足");
        RESULT.put("103","操作失败");
        RESULT.put("104","非法字符");
        RESULT.put("105","内容过多");
        RESULT.put("106","号码过多");
        RESULT.put("107","频率过快");
        RESULT.put("108","号码内容为空（用了UTF-8，不支持，改成GBK即可）");
        RESULT.put("109","账号冻结");
        RESULT.put("110","禁止频繁单条发送");
        RESULT.put("111","系统暂定发送");
        RESULT.put("112","子号不正确");
        RESULT.put("120","非法信息拒绝验证码炸弹或签名黑名单或双签名");
        RESULT.put("-1","连接失败");
    }


}
