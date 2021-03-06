package com.produtopostgres.cadprodutopostgres.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket produtoapi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.produtopostgres.cadprodutopostgres"))
                .paths(regex("/api.*"))
                .build()
                .apiInfo(metaInfo());
    }
    private ApiInfo metaInfo() {
        ApiInfo apiInfo = new ApiInfo(
                "Produtos API REST",
                "API REST para cadastro de produtos.",
                "1.0",
                "Terms of service",
                new Contact("João Batista","joaobatista.com.br","joao.batista.jrs@gmail.com"),
                "Apache License version 2.0",
                "https://www.apache.org/license.html",new ArrayList<VendorExtension>());
        return apiInfo;
    }
}