package com.dapp.server.market;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@ComponentScan(basePackages={"com.dapp.server"})
@SpringBootApplication
@EnableDiscoveryClient
@ServletComponentScan
@EnableSwagger2
@EnableFeignClients
@EnableHystrix
@EnableCaching
public class MarkApplication {
    public static void main(String[] args) {
        initSystemConfig();
        SpringApplication.run(MarkApplication.class, args);
    }

    /**
     * 初始化系统配置
     *
     */
    private static void initSystemConfig() {
        System.setProperty("log.root","ALL,CONSOLE,info,error,DEBUG");
        System.setProperty("service.id","blockchain-market-server");
    }

    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.dapp.server.market.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("行情系统（blockchain-market-server）RESTful APIs")
                .description("")
                .termsOfServiceUrl("")
                .version("1.0")
                .build();
    }
}
