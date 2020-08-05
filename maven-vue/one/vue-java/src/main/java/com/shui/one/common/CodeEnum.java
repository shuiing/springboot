package com.shui.one.common;

/**
 * 错误结果
 */
public enum CodeEnum {

    /** 返回结果 */
    SUCCESS (200,"请求成功"),
    FAIL (500,"内部错误");

    private int code;
    private String value;

    CodeEnum(int code, String value) {
        this.code = code;
        this.value = value;
    }

    public int code() {
        return code;
    }

    public String value() {
        return value;
    }
}
