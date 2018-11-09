package com.dapp.server.market.dto;

import com.dapp.server.base.model.BaseModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyDto extends BaseModel {

	private String currencyName;
	private String currencyNameCn;
	private String status;

}