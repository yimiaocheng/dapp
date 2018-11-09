package com.dapp.commom.utils.result;

import com.dapp.commom.dto.ResultDto;
import com.dapp.commom.enums.BaseResultEnums;

public class ResultUtils {

    /**
     * 创建请求成功返回数据
     *
     * @param result
     * @return
     */
    public static <T extends Object> ResultDto buildSuccessDto(T result) {
        ResultDto resultDto = new ResultDto();
        resultDto.setCode(BaseResultEnums.SUCCESS.getCode());
        resultDto.setMsg(BaseResultEnums.SUCCESS.getMsg());
        resultDto.setEnMsg(BaseResultEnums.SUCCESS.getEnMsg());
        resultDto.setData(result);
        return resultDto;
    }

}
