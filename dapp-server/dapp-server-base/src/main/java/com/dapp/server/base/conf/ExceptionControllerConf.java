package com.dapp.server.base.conf;

import com.dapp.server.base.handler.ExceptionControllerHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExceptionControllerConf {
    @Bean
    public ExceptionControllerHandler exceptionControllerHandler() {
        return new ExceptionControllerHandler();
    }
}
