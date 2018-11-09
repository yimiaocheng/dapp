package com.dapp.commom.enums;

public enum BaseResultEnums {
    SUCCESS("200","请求成功","Request success"),
    NO_LOGIN("201","未登录","No login"),

    HTTP_GET_ERROR("505","请求出错","Request error"),
    HTTP_POST_ERROR("505","请求出错","Request error"),
    DEFAULT("500","未知错误","System error");

    private String code;
    private String msg;
    private String enMsg;

    BaseResultEnums(String code, String msg, String enMsg) {
        this.code = code;
        this.msg = msg;
        this.enMsg = enMsg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public String getEnMsg() {
        return enMsg;
    }

}
