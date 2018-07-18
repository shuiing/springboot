package com.jiangshui.springbootpractic.practice.exception.exception_map;

/**
 * @author xujiangshui
 * @Date on 2018/7/18 0018
 */

import com.jiangshui.springbootpractic.practice.exception.exception_enum.ExceptionEnum;

/**
 * 运行错误
 */
public class CrowdMapException extends RuntimeException {

    //采用map的方式存储异常
    private String code;
    public String getCode(){
        return code;
    }
    public CrowdMapException(String code){
        super();
        this.code = code;
    }

}
