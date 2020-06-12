package com.syh.demo.multi.datasource.jta.service;

import com.syh.demo.multi.datasource.jta.dao.test02.TeacherDao;
import com.syh.demo.multi.datasource.jta.entity.Teacher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author HSY
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class TeacherService {
	private final TeacherDao teacherDao;

	public TeacherService(TeacherDao teacherDao) {
		this.teacherDao = teacherDao;
	}

	public void saveTeacher(Teacher teacher) {
		teacherDao.save(teacher);
	}

	public void saveTeacher2(Teacher teacher) {
		int i = 1 / 0;
		teacherDao.save(teacher);
	}
}
