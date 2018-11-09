package com.dapp.server.base.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tk.mybatis.spring.mapper.MapperScannerConfigurer;

@Configuration
public class TkMybatisConf {
    private static final String POJO_PACKAGE = "com.dapp.server.*.mapper";

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer(){
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage(POJO_PACKAGE);
        return mapperScannerConfigurer;
    }
}
