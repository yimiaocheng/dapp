package com.dapp.server.market.service;


import com.dapp.server.market.dto.CurrencyDto;

import java.util.List;

public interface CurrencyService {

    List<CurrencyDto> query(String currency);

}
