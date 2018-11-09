package com.dapp.server.market.enums;

public enum CurrencyResultEnums {
    API_ERROR("2100","API不存在","");
    private String code;
    private String msg;
    private String enMsg;

    CurrencyResultEnums(String code, String msg, String enMsg) {
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
