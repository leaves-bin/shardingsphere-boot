package com.bruce.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

/**
 * @author yongbin
 */
@EnableSwagger2
@Configuration
public class Swagger2Config {

    public List<Parameter> buildHeader() {
        return null;
    }

    @Bean
    public Docket apiRest() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("TEST")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.bruce.business.controller"))
                .paths(PathSelectors.any())
                .build()
                .globalOperationParameters(buildHeader())
                .enable(true);
    }

}
