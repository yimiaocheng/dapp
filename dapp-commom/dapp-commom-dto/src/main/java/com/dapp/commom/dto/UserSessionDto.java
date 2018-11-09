package com.dapp.commom.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserSessionDto implements Serializable {
    private Long userId;
    private String telephone;
    private String ethAddr;
    private String token;
    private String clientid;
}
