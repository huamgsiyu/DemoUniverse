package com.syh.demo.multi.datasource.jta.config;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author huangsiyu
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ConfigurationProperties(prefix = "spring.datasource.test2")
public class Datasource2 {
	private String jdbcUrl;
	private String username;
	private String password;
}
