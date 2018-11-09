package com.dapp.server.market.dto;

import com.dapp.server.base.model.BaseModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyMarketDto extends BaseModel {

    private Long id;
    private String currencyPair;
    private Double amount;
    private Date marketTime;

}