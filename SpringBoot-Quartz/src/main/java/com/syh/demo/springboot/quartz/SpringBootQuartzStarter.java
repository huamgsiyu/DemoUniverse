package com.syh.demo.springboot.quartz;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * SpringBootQuartzStarter
 *
 * @author HSY
 * @since 2020/06/01 23:18
 */

@MapperScan("com.syh.demo.springboot.quartz.mapper")
@SpringBootApplication
public class SpringBootQuartzStarter {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootQuartzStarter.class, args);
    }
}
