package com.dapp.server.ore.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * CoinDto 数据传输类
 * @date 2018-11-05 15:09:43
 * @version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CoinDto {
	private String id;
	private String userOpenId;
	private String coinAmount;
	private java.util.Date ceateTime;
	private String status;

}