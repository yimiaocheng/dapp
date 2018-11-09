package com.dapp.server.eth.dto;

import com.dapp.server.eth.model.Power;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WalletInfo {
    private String addr;
    private String userOpenId;
    private String privateKey;
    private String keystore;
    private String balance;
    private java.util.Date createTime;
    private java.util.Date updateTime;

    private Power power;
}
