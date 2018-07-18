package com.jiangshui.springbootpractic.practice.exception.exception_enum;

/**
 * @author xujiangshui
 * @Date on 2018/7/18 0018
 */
public enum ExceptionEnum {
    USER_ID_NULL(10001,"不能为空"),
    PHONE_NULL(10002,"手机号不能为空"),
    PWD_NULL(10013,"密码为空"),
    GET_PHONE_CODE_NULL(10014,"获取验证码失败"),
    GET_PHONE_CODE_TIME_NULL(10015,"获取验证码发送时间失败"),

    // 系统
    SYSTEM_ERROR(999999, "系统异常")
    ;
    private int code;
    private String message;

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return message;
    }

    ExceptionEnum(int code, String message){
        this.code = code;
        this.message = message;
    }




}
