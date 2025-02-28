package com.korit.project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Controller
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return  new Docket(DocumentationType.SWAGGER_2)
                .select()
                // 해당 패키지 안에 모든 컨트롤러 스웨거 적용
                .apis(RequestHandlerSelectors.basePackage("com.korit.project.controller"))
                // 모든 URL 스웨어 적용
                .paths(PathSelectors.any())
                .build()
                .apiInfo(getApiInfo());
    }

    private ApiInfo getApiInfo() {
        return new ApiInfoBuilder()
                .title("API 문서 제목")
                .description("API 문서 설명")
                .version("1.0")
                .contact(new Contact("관리자", "주소", "이메일"))
                .build();
    }
}
