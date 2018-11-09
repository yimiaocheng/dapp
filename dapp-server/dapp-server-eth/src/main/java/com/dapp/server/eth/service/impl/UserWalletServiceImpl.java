package com.dapp.server.eth.service.impl;

import com.codingapi.tx.annotation.ITxTransaction;
import com.dapp.server.eth.mapper.WalletTransferMapper;
import com.dapp.server.eth.model.Wallet;
import com.dapp.server.eth.model.WalletTransfer;
import com.dapp.server.eth.service.UserWalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class UserWalletServiceImpl implements UserWalletService,ITxTransaction{

    @Autowired
    private WalletTransferMapper walletTransferMapper;

    @Override
    @Transactional
    public void addUserWallet() {

        WalletTransfer wallet = new WalletTransfer();
        wallet.setHash(UUID.randomUUID().toString());

        walletTransferMapper.insert(wallet);


    }
}
