package com.dapp.server.market.service;


import com.dapp.server.market.dto.CurrencyMarketDto;
import com.dapp.server.market.model.CurrencyMarket;

import java.util.List;

public interface CurrencyMarketService {

    CurrencyMarketDto save(CurrencyMarket currencyMarket);

    CurrencyMarketDto get(String currencyPair, Long timestamp);

    List<CurrencyMarketDto> query(String currencyPair, Long startTimestamp, Long endTimestamp);

}
