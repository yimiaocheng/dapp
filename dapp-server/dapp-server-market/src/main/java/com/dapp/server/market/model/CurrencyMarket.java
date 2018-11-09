package com.dapp.server.market.model;

import com.dapp.server.base.model.BaseModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Table(name = "dapp_currency_market")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyMarket extends BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "currency_pair")
    private String currencyPair;
    @Column(name = "amount")
    private Double amount;
    @Column(name = "timestamp")
    private Date timestamp;

}