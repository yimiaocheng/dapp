package com.dapp.server.ore.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * SysParamDto 数据传输类
 *
 * @version 1.0
 * @date 2018-11-05 15:09:43
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysParamDto {
    private Integer id;
    private String paramName;
    private String paramValue;
    private String paramDescr;

}