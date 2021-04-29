package com.lainey.wiki.exception;
// 定义了各种异常的key和value
public enum BusinessExceptionCode {
// 枚举 之后的业务校验就在这里增加一个枚举即可
    USER_LOGIN_NAME_EXIST("登录名已存在"),
    ;

    private String desc;

    BusinessExceptionCode(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
