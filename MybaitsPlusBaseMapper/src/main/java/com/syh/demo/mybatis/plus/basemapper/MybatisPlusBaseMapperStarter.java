package com.syh.demo.mybatis.plus.basemapper;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Application
 *
 * @author HSY
 * @since 2020/06/24 21:36
 */
@SpringBootApplication
@MapperScan("com.syh.demo.mybatis.plus.basemapper.mapper")
@EnableScheduling
public class MybatisPlusBaseMapperStarter {
    public static void main(String[] args) {
        SpringApplication.run(MybatisPlusBaseMapperStarter.class, args);
    }

}
