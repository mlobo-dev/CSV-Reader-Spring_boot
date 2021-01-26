package com.dev4abyss.csvreader.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.dev4abyss.csvreader.controller"))
                .paths(PathSelectors.any())
                .build()
                .groupName("Dev4Abyss")
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "CSV Reader REST API",
                "This api will be used for rest requisitions.",
                "Versão beta-1.0",
                "",
                new Contact("Márcio Lôbo", "https://github.com/mlobo-dev", "mlobo.dev@gmail.com"),
                "",
                "",
                Collections.emptyList()
        );
    }
}
