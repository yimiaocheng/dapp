package com.dapp.server.ore.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * PowerTaskDto 数据传输类
 *
 * @version 1.0
 * @date 2018-11-05 15:09:43
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PowerTaskDto {
    private Integer id;
    private String taskName;
    private String taskDescr;
    private String taskPower;
    private Integer taskCount;
    private String status;
    private java.util.Date updateTime;

}