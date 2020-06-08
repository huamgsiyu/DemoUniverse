package com.syh.demo.mybatis.generator.templates;

import lombok.Data;

@Data
public class Table {
    /**
     * 表名称
     */
    private String tableName;
    private String fullName;
    private String simpleName;
    private String lowName;
    private String comment;
    private String packageName;
}
