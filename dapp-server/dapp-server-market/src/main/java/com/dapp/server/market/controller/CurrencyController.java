package com.dapp.server.market.controller;

import com.dapp.commom.dto.ResultDto;
import com.dapp.commom.utils.result.ResultUtils;
import com.dapp.server.market.controller.api.CurrencyApi;
import com.dapp.server.market.service.CurrencyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api(CurrencyApi.MARKET_CONTROLLER_API)
@RestController
@RequestMapping("/market/currency")
public class CurrencyController {

    @Autowired
    private CurrencyService currencyService;

    @ApiOperation(value = CurrencyApi.Query.METHOD_API_NAME,
            notes = CurrencyApi.Query.METHOD_API_NOTE)
    @RequestMapping(value = "/query", method = RequestMethod.GET)
    public ResultDto market(
            @ApiParam(CurrencyApi.Query.METHOD_API_CURRENCY)String currency){

        return ResultUtils.buildSuccessDto(currencyService.query(currency));
    }

}
