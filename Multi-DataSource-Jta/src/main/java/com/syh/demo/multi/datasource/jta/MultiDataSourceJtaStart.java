package com.syh.demo.multi.datasource.jta;

import com.syh.demo.multi.datasource.jta.config.Datasource1;
import com.syh.demo.multi.datasource.jta.config.Datasource2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * {@link MultiDataSourceJtaStart}
 *
 * @author HSY
 * @since 2020/05/29 14:55
 */
@SpringBootApplication
@EnableConfigurationProperties(value = { Datasource1.class, Datasource2.class })
public class MultiDataSourceJtaStart {
    public static void main(String[] args) {
        SpringApplication.run(MultiDataSourceJtaStart.class, args);
    }
}
