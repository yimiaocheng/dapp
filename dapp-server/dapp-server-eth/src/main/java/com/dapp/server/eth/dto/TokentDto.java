package com.dapp.server.eth.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * TokentDto 数据传输类
 * @date 2018-11-05 15:10:47
 * @version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TokentDto {
	private String tokenAddr;
	private String tokenName;
	private Integer tokenDecimals;

}