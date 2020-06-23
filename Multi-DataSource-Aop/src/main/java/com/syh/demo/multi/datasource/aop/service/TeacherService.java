package com.syh.demo.multi.datasource.aop.service;

import com.syh.demo.multi.datasource.aop.config.DataSourceType;
import com.syh.demo.multi.datasource.aop.entity.Teacher;
import com.syh.demo.multi.datasource.aop.mapper.test02.TeacherMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author HSY
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class TeacherService {
	private final TeacherMapper teacherMapper;

	public TeacherService(TeacherMapper teacherMapper) {
		this.teacherMapper = teacherMapper;
	}


	public void saveTeacher(Teacher teacher) {
		DataSourceType.setDataBaseType(DataSourceType.DataBaseType.TEST02);
		teacherMapper.save(teacher);
	}

	public void saveTeacher2(Teacher teacher) {
		int i = 1 / 0;
		teacherMapper.save(teacher);
	}
}
