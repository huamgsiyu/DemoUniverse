package com.syh.demo.multi.datasource.jta.mapper.test01;

import org.springframework.stereotype.Repository;
import com.syh.demo.multi.datasource.jta.entity.Student;

/**
 * @author HSY
 */
@Repository
public interface StudentMapper {

	/**
	 * 新增
	 * @param student	学生
	 */
	void save(Student student);

}
