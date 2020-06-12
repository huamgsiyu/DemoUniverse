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
public class Student {
	@ApiModelProperty("主键")
	private String id;

	@ApiModelProperty(value = "用户Id", example = "hsy")
	private String userId;

	@ApiModelProperty(value = "分数", example = "100")
	private int score;

	@ApiModelProperty(value = "班级Id", example = "14003")
	private String classId;
}
