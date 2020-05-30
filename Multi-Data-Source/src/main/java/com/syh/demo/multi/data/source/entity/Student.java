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
public class Student {
	@ApiModelProperty("主键")
	private String id;

	@ApiModelProperty("用户Id")
	private String userId;

	@ApiModelProperty("分数")
	private int score;

	@ApiModelProperty("班级Id")
	private String classId;
	/*
		SET NAMES utf8mb4;
		SET FOREIGN_KEY_CHECKS = 0;

		-- ----------------------------
		-- Table structure for student
		-- ----------------------------
		DROP TABLE IF EXISTS `student`;
		CREATE TABLE `student`  (
		  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
		  `userId` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
		  `score` int(10) NULL DEFAULT NULL,
		  `classId` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
		  PRIMARY KEY (`id`) USING BTREE
		) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

		SET FOREIGN_KEY_CHECKS = 1;
	 */
}
