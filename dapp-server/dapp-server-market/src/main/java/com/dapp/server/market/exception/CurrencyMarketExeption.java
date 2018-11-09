package com.dapp.server.market.exception;


import com.dapp.commom.exception.BaseException;
import com.dapp.server.market.enums.CurrencyMarketResultEnums;

public class CurrencyMarketExeption extends BaseException {
    public CurrencyMarketExeption(CurrencyMarketResultEnums code) {
        super(code.getCode(), code.getMsg(), code.getEnMsg());
    }
}
