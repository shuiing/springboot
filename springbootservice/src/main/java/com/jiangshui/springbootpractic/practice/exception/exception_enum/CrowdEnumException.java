package com.jiangshui.springbootpractic.practice.exception.exception_enum;

/**
 * @author xujiangshui
 * @Date on 2018/7/18 0018
 */

/**
 * 运行错误
 */
public class CrowdEnumException extends RuntimeException {

    //采用枚举的方式存储异常
    private Integer code;

    private String messages;

    public Integer getCode(){ return code; }

    public String getMessages() {
        return messages;
    }

    public CrowdEnumException(ExceptionEnum exception){
        super();
        this.code = exception.getCode();
        this.messages = exception.getMsg();
    }

}
