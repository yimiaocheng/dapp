package com.dapp.server.ore.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * CoinHistoryDto 数据传输类
 * @date 2018-11-05 15:09:43
 * @version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CoinHistoryDto {
	private String coinId;
	private java.util.Date createTime;

}