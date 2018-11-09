package com.dapp.server.base.handler;

import com.dapp.commom.dto.ResultDto;
import com.dapp.commom.enums.BaseResultEnums;
import com.dapp.commom.exception.BaseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@ControllerAdvice
@RestController
public class ExceptionControllerHandler<T extends BaseException> {
    private Logger logger = LoggerFactory.getLogger(ExceptionControllerHandler.class);

    /**
     * 处理系统出现的异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(BaseException.class)
    @ResponseStatus(HttpStatus.OK)
    public ResultDto commonException(T e) {
        logger.info("{}系统抛出异常，异常是：{}，异常信息是：{}", new Date(), e.getClass().getName(), e.getMessage());
        e.printStackTrace();
        return new ResultDto(e.getCode(),e.getMsg(),e.getEnMsg());
    }

    /**
     * 处理未知错误
     *
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.OK)
    public ResultDto otherEx(T e) {
        logger.info("{}系统抛出异常，异常是：{}，异常信息是：{}", new Date(), e.getClass().getName(), e.getMessage());
        e.printStackTrace();
        return new ResultDto(BaseResultEnums.DEFAULT.getCode(), BaseResultEnums.DEFAULT.getMsg(),BaseResultEnums.DEFAULT.getEnMsg());
    }

}
