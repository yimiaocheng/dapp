package com.dapp.server.ore.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * PowerHistoryDto 数据传输类
 * @date 2018-11-05 15:09:43
 * @version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PowerHistoryDto {
	private String id;
	private String powerCount;
	private String userOpenId;
	private String historyType;
	private Integer taskId;
	private java.util.Date createTime;

}