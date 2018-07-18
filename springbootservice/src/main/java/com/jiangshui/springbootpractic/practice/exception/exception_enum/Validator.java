package com.jiangshui.springbootpractic.practice.exception.exception_enum;


/**
 * @author xujiangshui
 * @Date on 2018/7/18 0018
 */
public class Validator {
    public void invalid(ExceptionEnum exceptionEnum){
        throw new CrowdEnumException(exceptionEnum);
    }

    public void assertEmpty(Object param,ExceptionEnum exceptionEnum){
        if(param == null | param.equals("")){
           throw new CrowdEnumException(exceptionEnum);
        }
    }
}
