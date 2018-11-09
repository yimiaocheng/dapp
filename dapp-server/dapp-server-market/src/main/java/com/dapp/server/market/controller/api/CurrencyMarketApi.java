package com.dapp.server.market.controller.api;

public class CurrencyMarketApi {
    public static final String MARKET_CONTROLLER_API = "数字货币行情控制器";

    public static class Get{
        public static final String METHOD_API_NAME = "获取数字货币最新行情";
        public static final String METHOD_API_NOTE = "获取数字货币最新行情";
        public static final String METHOD_API_CURRENCY_PAIR="数字货币对";
        public static final String METHOD_API_TIMESTAMP="时间戳";
    }

    public static class Query{
        public static final String METHOD_API_NAME = "获取数字货币行情列表";
        public static final String METHOD_API_NOTE = "获取数字货币行情列表";
        public static final String METHOD_API_CURRENCY_PAIR="数字货币对";
        public static final String METHOD_API_STARTTIMESTAMP="开始时间戳";
        public static final String METHOD_API_ENDTIMESTAMP="结束时间戳";
    }

}
