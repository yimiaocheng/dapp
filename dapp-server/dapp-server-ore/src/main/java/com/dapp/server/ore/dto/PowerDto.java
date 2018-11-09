package com.dapp.server.ore.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * PowerDto 数据传输类
 * @date 2018-11-05 15:09:43
 * @version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PowerDto {
	private String id;
	private String userOpenId;
	private String powerCount;
	private java.util.Date updateTime;

}