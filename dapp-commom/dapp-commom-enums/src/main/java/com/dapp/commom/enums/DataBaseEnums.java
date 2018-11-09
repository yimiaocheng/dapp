package com.dapp.commom.enums;

public enum DataBaseEnums {
    USABLE("USABLE","可用"),
    UNUSABLE("UNUSABLE","禁用"),
    DELETE("DELETE","删除"),
    NOTALLOW("NOTALLOW","未审核"),
    UNALLOW("UNALLOW","审核不通过"),

    SALE("SALE","出售"),
    BUY("BUY","购买"),

    WX("WX","微信"),
    ALIPAY("ALIPAY","支付宝"),

    PIC("PIC","图片"),
    VIDEO("VIDEO","视频"),

    USER("USER","用户"),
    BILL("BILL","交易表单"),

    ETH("ETH","以太币");

    DataBaseEnums(String value, String comment){
        this.value = value;
        this.comment = comment;
    }

    private String value;
    private String comment;

    public String getValue() {
        return value;
    }


    public String getComment() {
        return comment;
    }

}
