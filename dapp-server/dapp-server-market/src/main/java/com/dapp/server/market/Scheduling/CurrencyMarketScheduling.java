package com.dapp.server.market.Scheduling;

import com.dapp.commom.utils.http.HttpUtilManager;
import com.dapp.commom.utils.json.JsonUtils;
import com.dapp.server.market.model.CurrencyMarket;
import com.dapp.server.market.service.CurrencyMarketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
@Configurable
@EnableScheduling
public class CurrencyMarketScheduling {

    private static ExecutorService cachedThreadPool = Executors.newCachedThreadPool();

    @Autowired
    private CurrencyMarketService currencyMarketService;

    @Scheduled(cron = "0/10 * * * * *")
    public void getCurrencyMarket() {
        Map<String, String> krakenCurrencyPairs = new HashMap();
        krakenCurrencyPairs.put("ETH", "XETHZUSD");
        krakenCurrencyPairs.put("EOS", "EOSUSD");
        krakenCurrencyPairs.put("BCH", "BCHUSD");
        krakenCurrencyPairs.put("USDT", "USDTZUSD");
        krakenCurrencyPairs.put("LTC", "XLTCZUSD");
        krakenCurrencyPairs.put("XRP", "XXRPZUSD");
        krakenCurrencyPairs.put("ETC", "XETCZUSD");
        Double usdCny = saveUsdCnyMarket();
        for (String currency : krakenCurrencyPairs.keySet()) {
            String krakenCurrencyPair = krakenCurrencyPairs.get(currency);
            saveCurrencyMarket(currency, krakenCurrencyPair, usdCny);
        }
        saveBtcUsdMarket();
        Map<String, String> currencyPairs = new HashMap();

    }

    private void saveCurrencyMarket(String currency, String krakenCurrencyPair, Double usdCny) {
        cachedThreadPool.execute(new Runnable() {
            @Override
            public void run() {
                HttpUtilManager http = HttpUtilManager.getInstance();
                String url = "https://api.kraken.com/0/public/Trades?pair=" + krakenCurrencyPair;
                String result = http.requestHttpGet(url, null);
                Map<String, Object> dataMap = JsonUtils.jsonToHashMap(result, String.class, Object.class);
                Map<String, Object> resultMap = (Map<String, Object>) dataMap.get("result");
                List<List<Object>> trades = (List<List<Object>>) resultMap.get(krakenCurrencyPair);
                Double amount = new Double(trades.get(trades.size() - 1).get(0).toString());
//                Long timestamp = new Long(trades.get(trades.size() - 1).get(2).toString()) * 1000;
                Date now = new Date();
                CurrencyMarket currencyMarket = new CurrencyMarket();
                currencyMarket.setCurrencyPair(currency + "-USD");
                currencyMarket.setAmount(amount);
                currencyMarket.setTimestamp(now);
                currencyMarketService.save(currencyMarket);
                if (usdCny != null && usdCny != 0) {
                    CurrencyMarket currencyCnyMarket = new CurrencyMarket();
                    currencyCnyMarket.setCurrencyPair(currency + "-CNY");
                    currencyCnyMarket.setAmount(amount * usdCny);
                    currencyCnyMarket.setTimestamp(now);
                    currencyMarketService.save(currencyCnyMarket);
                }
            }
        });
    }

    private void saveBtcUsdMarket() {
        cachedThreadPool.execute(new Runnable() {
            @Override
            public void run() {
                HttpUtilManager http = HttpUtilManager.getInstance();
                String result = http.requestHttpGet("https://api.coinbase.com/v2/prices/BTC-CNY/sell", null);
                Map<String, Object> resultMap = JsonUtils.jsonToHashMap(result, String.class, Object.class);
                Map<String, String> dataMap = (Map<String, String>) resultMap.get("data");
                Date now = new Date();
                CurrencyMarket currencyMarket = new CurrencyMarket();
                currencyMarket.setCurrencyPair("BTC-CNY");
                currencyMarket.setAmount(new Double(dataMap.get("amount")));
                currencyMarket.setTimestamp(now);
                currencyMarketService.save(currencyMarket);
            }
        });
        cachedThreadPool.execute(new Runnable() {
            @Override
            public void run() {
                HttpUtilManager http = HttpUtilManager.getInstance();
                String result = http.requestHttpGet("https://api.coinbase.com/v2/prices/BTC-USD/sell", null);
                Map<String, Object> resultMap = JsonUtils.jsonToHashMap(result, String.class, Object.class);
                Map<String, String> dataMap = (Map<String, String>) resultMap.get("data");
                Date now = new Date();
                CurrencyMarket currencyMarket = new CurrencyMarket();
                currencyMarket.setCurrencyPair("BTC-USD");
                currencyMarket.setAmount(new Double(dataMap.get("amount")));
                currencyMarket.setTimestamp(now);
                currencyMarketService.save(currencyMarket);
            }
        });
    }

    private Double saveUsdCnyMarket() {
        HttpUtilManager http = HttpUtilManager.getInstance();
        String result = http.requestHttpGet("https://api.coinbase.com/v2/exchange-rates?currency=USD", null);
        Map<String, Object> resultMap = JsonUtils.jsonToHashMap(result, String.class, Object.class);
        Map<String, Object> dataMap = (Map<String, Object>) resultMap.get("data");
        Map<String, Object> rates = (Map<String, Object>) dataMap.get("rates");
        Double amount = new Double(rates.get("CNY").toString());
        Date now = new Date();
        CurrencyMarket currencyMarket = new CurrencyMarket();
        currencyMarket.setCurrencyPair("USD-CNY");
        currencyMarket.setAmount(amount);
        currencyMarket.setTimestamp(now);
        currencyMarketService.save(currencyMarket);
        return amount;
    }
}
