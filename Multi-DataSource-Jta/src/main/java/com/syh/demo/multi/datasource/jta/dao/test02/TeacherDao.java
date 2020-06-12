package com.syh.demo.multi.datasource.jta.dao.test02;

import com.syh.demo.multi.datasource.jta.entity.Teacher;
import com.syh.demo.multi.datasource.jta.mapper.test02.TeacherMapper;
import org.springframework.stereotype.Component;

/**
 * @author HSY
 */
@Component
public class TeacherDao {

	private final TeacherMapper teacherMapper;

	public TeacherDao(TeacherMapper teacherMapper) {
		this.teacherMapper = teacherMapper;
	}

	public void save(Teacher teacher) {
		teacherMapper.save(teacher);
	}
}
