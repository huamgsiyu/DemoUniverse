package com.syh.demo.swagger2.authentication;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Swagger2AuthenticationStarter
 *
 * @author HSY
 * @since 2020/06/10 21:55
 */
@SpringBootApplication(scanBasePackages = {"com.syh.demo.swagger2.authentication"})
@MapperScan(basePackages = "com.syh.demo.swagger2.authentication.mapper")
public class Swagger2AuthenticationStarter {
    public static void main(String[] args) {
        SpringApplication.run(Swagger2AuthenticationStarter.class, args);
    }
}
