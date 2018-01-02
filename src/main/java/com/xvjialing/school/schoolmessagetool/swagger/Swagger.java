package com.xvjialing.school.schoolmessagetool.swagger;

import com.google.common.collect.Lists;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger {

    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.xvjialing.school.schoolmessagetool.controller"))
                .paths(PathSelectors.any())
                .build();
//                .securitySchemes(Lists.newArrayList(apiKey()));
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("School Message Tool Rest API Document")
                .description("decription for school message tool api")
                .termsOfServiceUrl("www.xvjialing.xyz")
                .contact("xvjialing")
                .version("1.0")
                .build();
    }

//    /**
//     * 用来设置Jwt Token
//     * @return
//     */
//    private ApiKey apiKey() {
//        return new ApiKey("apikey", "Authorization", "header");
//    }
}