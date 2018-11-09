package com.dapp.commom.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonSerialize
public class ResultDto<T> implements Serializable{
    private String code;
    private String msg;
    private String enMsg;
    private T data;

    public ResultDto(String code, String msg, String enMsg) {
        this.code = code;
        this.msg = msg;
        this.enMsg = enMsg;
    }
}
