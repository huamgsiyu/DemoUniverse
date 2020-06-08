package com.syh.demo.mybatis.generator.templates.config;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * PropertyInjection
 *
 * @author HSY
 * @since 2020/06/07 10:09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class PropertyInjection {

    /**
     * 新增、更新、删除返回类
     */
    private String addUpdateDeleteOperationReturnName;

    /**
     * 新增、更新、删除返回类
     */
    private String addUpdateDeleteOperationReturnPackage;
    /**
     * 查询单个
     */
    private String selectOne;

    /**
     * 查询多个，List
     */
    private String selectList;

    /**
     * 查询多个Map
     */
    private String selectMap;
}
