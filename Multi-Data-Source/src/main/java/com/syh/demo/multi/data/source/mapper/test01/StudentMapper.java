package com.syh.demo.multi.data.source.mapper.test01;

import com.syh.demo.multi.data.source.entity.Student;
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
	void save(Student student);

}
