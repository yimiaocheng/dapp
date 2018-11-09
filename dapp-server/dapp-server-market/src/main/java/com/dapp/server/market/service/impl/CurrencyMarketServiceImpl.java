package com.dapp.server.market.service.impl;

import com.dapp.server.market.dto.CurrencyMarketDto;
import com.dapp.server.market.mapper.CurrencyMarketMapper;
import com.dapp.server.market.model.CurrencyMarket;
import com.dapp.server.market.service.CurrencyMarketService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("currencyMarketService")
public class CurrencyMarketServiceImpl implements CurrencyMarketService {

    @Autowired
    private CurrencyMarketMapper currencyMarketMapper;

    @Override
    public CurrencyMarketDto save(CurrencyMarket currencyMarket) {
        currencyMarketMapper.insert(currencyMarket);
        CurrencyMarketDto dto = new CurrencyMarketDto();
        BeanUtils.copyProperties(currencyMarket, dto);
        return dto;
    }

    @Override
    public CurrencyMarketDto get(String currencyPair, Long timestamp) {
        Map<String, Object> params = new HashMap();
        params.put("currencyPair", currencyPair);
        if (timestamp != null) {
            params.put("timestamp", timestamp);
        }
        return currencyMarketMapper.get(params);
    }

    @Override
    public List<CurrencyMarketDto> query(String currencyPair, Long startTimestamp, Long endTimestamp) {
        return null;
    }
}
