package com.shui.one.common;

import lombok.Data;

import java.io.Serializable;

/**
 * 统一返回结果
 */
@Data
public class Result implements Serializable {

    private Integer code;
    private String msg;
    private Object data;

    public static Result success() {
        Result m = new Result();
        m.setCode(CodeEnum.SUCCESS.code());
        m.setMsg(CodeEnum.SUCCESS.value());
        return m;
    }
    public static Result success(Object data) {
        Result m = Result.success();
        m.setData(data);
        return m;
    }
    public static Result success(String mess, Object data) {
        Result m = Result.success(data);
        m.setMsg(mess);
        return m;
    }
    public static Result fail() {
        Result m = new Result();
        m.setCode(CodeEnum.FAIL.code());
        m.setMsg(CodeEnum.FAIL.value());
        m.setData(null);
        return m;
    }
    public static Result fail(Object data) {
        Result m = Result.fail();
        m.setData(data);
        return m;
    }
    public static Result fail(String mess, Object data) {
        Result m =Result.fail(data);
        m.setMsg(mess);
        return m;
    }

}
