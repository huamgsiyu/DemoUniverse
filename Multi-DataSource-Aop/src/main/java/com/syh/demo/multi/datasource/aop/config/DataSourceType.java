package com.syh.demo.multi.datasource.aop.config;

import lombok.extern.slf4j.Slf4j;

/**
 * @author huangsiyu
 */
@Slf4j
public class DataSourceType {

	public enum DataBaseType {
		/**
		 *
		 */
		TEST01,
		/**
		 *
		 */
		TEST02
	}

	/**
	 * 使用ThreadLocal保证线程安全
	 */
	private static final ThreadLocal<DataBaseType> TYPE = new ThreadLocal<>();

	/**
	 * 往当前线程里设置数据源类型
	 * @param dataBaseType
	 */
	public static void setDataBaseType(DataBaseType dataBaseType) {
		if (dataBaseType == null) {
			throw new NullPointerException();
		}
		TYPE.set(dataBaseType);
		log.info("[将当前数据源改为]：" + dataBaseType);
	}

	/**
	 * 获取数据源类型
	 * @return
	 */
	public static DataBaseType getDataBaseType() {
		DataBaseType dataBaseType = TYPE.get() == null ? DataBaseType.TEST01 : TYPE.get();
		log.info("[获取当前数据源的类型为]：" + dataBaseType);
		return dataBaseType;
	}

	/**
	 * 清空数据类型
	 */
	public static void clearDataBaseType() {
		TYPE.remove();
	}
}
