package com.syh.demo.multi.datasource.jta.config;

import com.mysql.jdbc.jdbc2.optional.MysqlXADataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @author HSY
 */
@Configuration
@MapperScan(basePackages = "com.syh.demo.multi.datasource.jta.mapper.test02", sqlSessionFactoryRef = "test2SqlSessionFactory")
public class AtomikosDataSourceConfig2 {

	/**
	 * 事务管理
	 * @param dataSource	数据源
	 * @return	{@link DataSourceTransactionManager}
	 */
//	@Bean(name = "test2TransactionManager")
//	public DataSourceTransactionManager testTransactionManager(@Qualifier("test2DataSource") DataSource dataSource) {
//		return new DataSourceTransactionManager(dataSource);
//	}

	/**`
	 *	读取application.properties中的spring.datasource.test1前缀的配置参数映射成为一个对象
	 *
	 * @return				{@link DataSource}
	 */
	@Bean(name = "test2DataSource")
	public DataSource getDateSource1(Datasource2 datasource) {
		MysqlXADataSource mysqlxadatasource = new MysqlXADataSource();
		mysqlxadatasource.setUrl(datasource.getJdbcUrl());
		mysqlxadatasource.setPassword(datasource.getPassword());
		mysqlxadatasource.setUser(datasource.getUsername());
		mysqlxadatasource.setPinGlobalTxToPhysicalConnection(true);
		AtomikosDataSourceBean xaDataSource = new AtomikosDataSourceBean();
		xaDataSource.setXaDataSource(mysqlxadatasource);
		xaDataSource.setUniqueResourceName("test2DataSource");
		return xaDataSource;
	}

	/**
	 * 扫描指定包下的xml文件，然后返回一个{@link SqlSessionFactory}
	 *
	 * @param datasource	数据源
	 * @return				{@link SqlSessionFactory}
	 * @throws Exception	{@link SqlSessionFactoryBean}的getObject()方法出现异常
	 */
	@Bean(name = "test2SqlSessionFactory")
	public SqlSessionFactory test1SqlSessionFactory(
			// @Qualifier表示查找Spring容器中名字为test1DataSource的对象
			@Qualifier("test2DataSource") DataSource datasource) throws Exception {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(datasource);
		bean.setMapperLocations(
				new PathMatchingResourcePatternResolver().getResources("classpath*:mapping/test02/*.xml"));
		return bean.getObject();
	}

	/**
	 * 生成{@link SqlSessionTemplate}用于执行SQL
	 *
	 * @param sqlSessionFactory		SqlSession工厂
	 * @return	{@link SqlSessionTemplate}
	 */
	@Bean("test2SqlSessionTemplate")
	public SqlSessionTemplate test1SqlSessionTemplate(
			@Qualifier("test2SqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory);
	}
}
