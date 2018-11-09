package com.dapp.server.market.mapper;

import com.dapp.server.market.dto.CurrencyMarketDto;
import com.dapp.server.market.model.CurrencyMarket;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

@Repository
public interface CurrencyMarketMapper extends Mapper<CurrencyMarket> {

    List<CurrencyMarketDto> query(Map<String, Object> params);

    CurrencyMarketDto get(Map<String, Object> params);

}