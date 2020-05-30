package com.syh.demo.multi.data.source.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * @author HSY
 */
@Configuration
@MapperScan(basePackages = "com.syh.demo.multi.data.source.mapper.test01", sqlSessionFactoryRef = "test1SqlSessionFactory")
public class DataSourceConfig1 {

	/**`
	 *	读取application.properties中的spring.datasource.test1前缀的配置参数映射成为一个对象
	 *
	 * @return				{@link DataSource}
	 */
	@Bean(name = "test1DataSource")
	@Primary	//表示这个数据源是默认数据源
	@ConfigurationProperties(prefix = "spring.datasource.test1")
	public DataSource getDateSource1() {
		return DataSourceBuilder.create().build();
	}

	/**
	 * 扫描指定包下的xml文件，然后返回一个{@link SqlSessionFactory}
	 *
	 * @param datasource	数据源
	 * @return				{@link SqlSessionFactory}
	 * @throws Exception	{@link SqlSessionFactoryBean}的getObject()方法出现异常
	 */
	@Bean(name = "test1SqlSessionFactory")
	@Primary
	public SqlSessionFactory test1SqlSessionFactory(
			// @Qualifier表示查找Spring容器中名字为test1DataSource的对象
			@Qualifier("test1DataSource") DataSource datasource) throws Exception {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(datasource);
		bean.setMapperLocations(
				new PathMatchingResourcePatternResolver().getResources("classpath*:mapping/test01/*.xml"));
		return bean.getObject();
	}

	/**
	 * 生成{@link SqlSessionTemplate}用于执行SQL
	 *
	 * @param sqlSessionFactory		SqlSession工厂
	 * @return	{@link SqlSessionTemplate}
	 */
	@Bean("test1SqlSessionTemplate")
	@Primary
	public SqlSessionTemplate test1SqlSessionTemplate(
			@Qualifier("test1SqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory);
	}
}
