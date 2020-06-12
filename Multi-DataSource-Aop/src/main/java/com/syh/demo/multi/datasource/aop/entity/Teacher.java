package com.syh.demo.multi.datasource.aop.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @author HSY
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Teacher {

	@ApiModelProperty("主键")
	private String id;

	@ApiModelProperty(value = "姓名", example = "hqh")
	private String name;

	@ApiModelProperty(value = "班级Id", example = "14004")
	private String classId;
}
