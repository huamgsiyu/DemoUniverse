package com.syh.demo.springboot.quartz.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger2Config
 *
 * @author HSY
 * @since 2020/05/23 11:06
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {

    @Bean
    @Order(1)
    public Docket windowsModule () { return buildDocket("定时器", "com.syh.demo.springboot.quartz.controller");}

    private Docket buildDocket(String groupName, String basePackage) {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(initApiInfo())
                .groupName(groupName)
                .select()
                .paths(PathSelectors.any())
                .apis(RequestHandlerSelectors.basePackage(basePackage))
                .build();
    }

    private ApiInfo initApiInfo() {
        Contact contact = new Contact("HSY", "http://baidu.com", "90924XXXXXX@qq.com");
        return new ApiInfoBuilder().title("SpringBoot集成Mybatis+MybatisPlus")
                .description("简单的一个SpringBoot+Mybatis+MybatisPlus的demo")
                .version("1.0.0")
                .contact(contact)
                .build();
    }
}
