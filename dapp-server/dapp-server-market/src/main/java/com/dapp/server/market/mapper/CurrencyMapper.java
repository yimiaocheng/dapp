package com.dapp.server.market.mapper;

import com.dapp.server.market.dto.CurrencyDto;
import com.dapp.server.market.model.Currency;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

@Repository
public interface CurrencyMapper extends Mapper<Currency> {

    List<CurrencyDto> query(Map<String, Object> params);

}