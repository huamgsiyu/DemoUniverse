package com.syh.demo.multi.data.source.entity;

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

	@ApiModelProperty("姓名")
	private String name;

	@ApiModelProperty("班级Id")
	private String classId;

	/*
		SET NAMES utf8mb4;
		SET FOREIGN_KEY_CHECKS = 0;

		-- ----------------------------
		-- Table structure for teacher
		-- ----------------------------
		DROP TABLE IF EXISTS `teacher`;
		CREATE TABLE `teacher`  (
		  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
		  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
		  `classId` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
		  PRIMARY KEY (`id`) USING BTREE
		) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

		SET FOREIGN_KEY_CHECKS = 1;
	 */
}
