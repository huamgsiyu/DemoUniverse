package com.syh.demo.mybatis.generator.templates;

import cn.hutool.core.util.StrUtil;
import lombok.Data;

@Data
public class Field {

    private String column;
    private String property;
    private String upProperty;
    private String comment;
    private Boolean required;
    private String typeFullName;
    private String typeSimpleName;
    private String typeLowName;
    private String typePackageName;
    private String condition;
    private String validator;

    public void initCondition(Table table) {
        if (typeSimpleName.equals("String")) {
            condition = StrUtil.format(
                    ".like(isNotBlank(req.get{}()), {}::get{}, req.get{}())",
                    upProperty,
                    table.getSimpleName(),
                    upProperty,
                    upProperty
            );
        } else if (typeSimpleName.equals("List")
                || typeSimpleName.equals("Set")) {
            condition = StrUtil.format(
                    ".in(isNotEmpty(req.get{}()), {}::get{}, req.get{}())",
                    upProperty,
                    table.getSimpleName(),
                    upProperty,
                    upProperty
            );
        } else {
            condition = StrUtil.format(
                    ".eq(isNotNull(req.get{}()), {}::get{}, req.get{}())",
                    upProperty,
                    table.getSimpleName(),
                    upProperty,
                    upProperty
            );
        }
    }

    public void initValidator() {
        if (typeSimpleName.equals("List")
                || typeSimpleName.equals("Set")) {
            validator = StrUtil.format(
                    "CollValidator.notEmpty(entity.getId(), \"{}不能为空\");",
                    comment
            );
        } else {
            validator = StrUtil.format(
                    "Validator.validateNotEmpty(entity.get{}(), \"{}不能为空\");",
                    upProperty,
                    comment
            );
        }
    }
}
