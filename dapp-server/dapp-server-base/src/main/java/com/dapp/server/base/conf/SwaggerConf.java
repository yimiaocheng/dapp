package com.dapp.server.base.conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
@Configuration
@EnableSwagger2
public class SwaggerConf {
    @Value("${SwaggerAPIs.path:com.yuanshuju.api}")
    private String apiPath;
    @Value("${SwaggerAPIs.title:RESTful APIs}")
    private String apiTitle;
    @Value("${SwaggerAPIs.description:}")
    private String apiDescription;
    @Value("${SwaggerAPIs.version:v1.0}")
    private String apiVersion;
    @Value("${SwaggerAPIs.createby.name:}")
    private String apiCreateByName;
    @Value("${SwaggerAPIs.createby.url:}")
    private String apiCreateByUrl;
    @Value("${SwaggerAPIs.createby.email:}")
    private String apiCreateByEmail;


    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(apiPath))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title(apiTitle)
                .description(apiDescription)
                .termsOfServiceUrl("")
                .contact(new Contact(apiCreateByName,apiCreateByUrl,apiCreateByEmail))
                .version(apiVersion)
                .build();
    }
}
