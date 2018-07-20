package com.jiangshui.springbootpractic.practice.sms;

/**
 * @author xujiangshui
 * @Date on 2018/7/19 0019
 */


import java.util.HashMap;
import java.util.Map;

public class Sms {

    public static String JINGCAI_SMS_UID = "ceshi123";
    public static String SMSTAIL = "测试";
    public static String SENDSMS_URL="http://202.85.221.42:9885/c123/sendsms";
    public static String QUERYMONEY_URL="http://202.85.221.42:9885/c123/querymoney";

    public static void main(String [] args){
        String mobile = "18868945831";
        String content = "你好";
        System.out.println(send(mobile,content));
        System.out.println(queryMoney());
    }

    public static Object send(String mobile,String content){
        String password="";
        Map map = new HashMap();
        map.put("uid", JINGCAI_SMS_UID);
        map.put("pwd",password);
        map.put("mobile",mobile);
        map.put("content", SMSTAIL+content);
        String result = HttpUtils.URLPost(QUERYMONEY_URL, map, "gb2312");
        return SmsMessage.RESULT.get(result);

    }

    public static Object queryMoney(){
        String password="";

        Map map = new HashMap();
        map.put("uid", JINGCAI_SMS_UID);
        map.put("pwd",password);
        map.put("encode", "utf8");
        String result = HttpUtils.URLPost(SENDSMS_URL, map, "UTF-8");
        System.out.println(result);
        if("100".equals(result.substring(0,result.indexOf('{')))){
            return result.substring(result.indexOf('}')+1);
        }else {
            return SmsMessage.RESULT.get(result);
        }
    }



}

