package com.dapp.server.market.service.impl;

import com.dapp.server.market.dto.CurrencyDto;
import com.dapp.server.market.service.CurrencyService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("currencyService")
public class CurrencyServiceImpl implements CurrencyService {

    @Override
    public List<CurrencyDto> query(String currency) {
        return null;
    }
}
