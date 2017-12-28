package com.joe.chapter031.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
笔记：
1. @Configuration：启用该注解，spring会加载此配置。
2. @EnableSwagger2：启用swagger2。
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    /**
     * 创建该Api的基本信息（这些基本信息会展现在文档页面中）
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("演示系统")
                .description("展示swagger2以及restful使用规范")
                .termsOfServiceUrl("https://github.com/joejun/spring-boot-mark")
                .version("V1.0")
                .build();
    }

    /**
     * select()函数返回一个ApiSelectorBuilder实例用来控制哪些接口暴露给Swagger来展现，
     * 本例采用指定扫描的包路径来定义，Swagger会扫描该包下所有Controller定义的API，
     * 并产生文档内容（除了被@ApiIgnore指定的请求）。
     * @return
     */
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.leeyom.controller"))
                .apis(RequestHandlerSelectors.any())
//                .paths(PathSelectors.any())
                .paths(PathSelectors.regex("/swagger-restful/.*"))
                .build()
                .apiInfo(apiInfo())
                .enable(true)
                .useDefaultResponseMessages(false);
    }


}

