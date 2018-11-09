package com.dapp.server.market.dto;

import com.dapp.server.base.model.BaseModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyPairDto extends BaseModel {

	private String currencyPair;
	private String status;

}