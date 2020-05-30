package com.syh.demo.multi.data.source.dao.test02;

import com.syh.demo.multi.data.source.entity.Teacher;
import com.syh.demo.multi.data.source.mapper.test02.TeacherMapper;
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
