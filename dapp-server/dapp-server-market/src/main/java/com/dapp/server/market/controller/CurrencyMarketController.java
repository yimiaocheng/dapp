package com.dapp.server.market.controller;

import com.dapp.commom.dto.ResultDto;
import com.dapp.commom.utils.result.ResultUtils;
import com.dapp.server.market.controller.api.CurrencyMarketApi;
import com.dapp.server.market.service.CurrencyMarketService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api(CurrencyMarketApi.MARKET_CONTROLLER_API)
@RestController
@RequestMapping("/market")
public class CurrencyMarketController {

    @Autowired
    private CurrencyMarketService currencyPairService;

    @ApiOperation(value = CurrencyMarketApi.Get.METHOD_API_NAME,
            notes = CurrencyMarketApi.Get.METHOD_API_NOTE)
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public ResultDto market(
            @ApiParam(CurrencyMarketApi.Get.METHOD_API_CURRENCY_PAIR) String currencyPair,
            @ApiParam(CurrencyMarketApi.Get.METHOD_API_TIMESTAMP) Long timestamp) {

        return ResultUtils.buildSuccessDto(currencyPairService.get(currencyPair, timestamp));
    }

    @ApiOperation(value = CurrencyMarketApi.Query.METHOD_API_NAME,
            notes = CurrencyMarketApi.Query.METHOD_API_NOTE)
    @RequestMapping(value = "/query", method = RequestMethod.GET)
    public ResultDto query(
            @ApiParam(CurrencyMarketApi.Query.METHOD_API_CURRENCY_PAIR) String currencyPair,
            @ApiParam(CurrencyMarketApi.Query.METHOD_API_STARTTIMESTAMP) Long startTimestamp,
            @ApiParam(CurrencyMarketApi.Query.METHOD_API_ENDTIMESTAMP) Long endTimestamp) {

        return ResultUtils.buildSuccessDto(currencyPairService.query(currencyPair, startTimestamp, endTimestamp));
    }

}
