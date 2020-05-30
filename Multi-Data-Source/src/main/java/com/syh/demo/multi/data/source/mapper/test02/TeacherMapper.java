package com.syh.demo.multi.data.source.mapper.test02;

import com.syh.demo.multi.data.source.entity.Teacher;
import org.springframework.stereotype.Repository;

/**
 * @author HSY
 */
@Repository
public interface TeacherMapper {

	/**
	 * 新增
	 * @param teacher	教师
	 */
	void save(Teacher teacher);

}
