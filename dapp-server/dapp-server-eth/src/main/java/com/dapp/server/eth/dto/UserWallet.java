package com.dapp.server.eth.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserWallet {
   private String userId;
   private String username;

   private WalletInfo wallet;

}
