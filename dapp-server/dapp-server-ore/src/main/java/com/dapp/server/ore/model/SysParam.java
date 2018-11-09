package com.dapp.server.ore.model;

import com.dapp.server.base.model.BaseModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * SysParam 数据传输类
 *
 * @version 1.0
 * @date 2018-11-05 15:09:43
 */
@Table(name = "dapp_ore_sys_param")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysParam extends BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "param_name")
    private String paramName;
    @Column(name = "param_value")
    private String paramValue;
    @Column(name = "param_descr")
    private String paramDescr;

}