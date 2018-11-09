package com.dapp.commom.exception;

import com.dapp.commom.enums.BaseResultEnums;

public class BaseException extends RuntimeException {
    private String code;
    private String msg;
    private String enMsg;

    public BaseException(BaseResultEnums enums) {
        this(enums.getCode(), enums.getMsg(),enums.getEnMsg());
    }

    public BaseException(String code, String msg, String enMsg) {
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
