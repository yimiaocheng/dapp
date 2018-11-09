package com.dapp.server.eth.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User<T extends Object> implements Serializable {
    private String code;//返回码
    private String msg;//返回码描述
    private T data;

}
