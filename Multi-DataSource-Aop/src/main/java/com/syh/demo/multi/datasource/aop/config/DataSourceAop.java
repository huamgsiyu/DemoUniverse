package com.syh.demo.multi.datasource.aop.config;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @author huangsiyu
 */
@Aspect
@Component
public class DataSourceAop {
	@Before("execution(* com.syh.demo.multi.datasource.aop.service..*.test01*(..))")
	public void setDataSource2test01() {
		System.err.println("test01业务");
		DataSourceType.setDataBaseType(DataSourceType.DataBaseType.TEST01);
	}
	
	@Before("execution(* com.syh.demo.multi.datasource.aop.service..*.test02*(..))")
	public void setDataSource2test02() {
		System.err.println("test02业务");
		DataSourceType.setDataBaseType(DataSourceType.DataBaseType.TEST02);
	}
}
