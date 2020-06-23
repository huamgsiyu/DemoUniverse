package com.syh.demo.multi.datasource.aop.mapper.test01;

import com.syh.demo.multi.datasource.aop.entity.Student;
import org.springframework.stereotype.Repository;

/**
 * @author HSY
 */
@Repository
public interface StudentMapper {

	/**
	 * 新增
	 * @param student	学生
	 */
	Integer save(Student student);

}
