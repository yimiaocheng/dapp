package com.dapp.server.market.enums;

public enum CurrencyMarketResultEnums {
    API_ERROR("2200","API不存在","");
    private String code;
    private String msg;
    private String enMsg;

    CurrencyMarketResultEnums(String code, String msg, String enMsg) {
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
