package com.syh.demo.multi.data.source.service;

import com.syh.demo.multi.data.source.dao.test01.StudentDao;
import com.syh.demo.multi.data.source.dao.test02.TeacherDao;
import com.syh.demo.multi.data.source.entity.Teacher;
import com.syh.demo.multi.data.source.entity.Student;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/**
 * @author HSY
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class StudentService {
	private final StudentDao studentDao;
	private final TeacherDao teacherDao;

	public StudentService(StudentDao studentDao, TeacherDao teacherDao) {
		this.studentDao = studentDao;
		this.teacherDao = teacherDao;
	}

	public void saveStudent(Student student) {
		studentDao.save(student);
	}

	public void saveStudent2(Student student) {
		loadTeacher(student);
	}

	public void saveStudent3(Student student) {
		loadTeacher(student);
	}

	public void saveStudent4(Student student) {
		loadTeacher(student);
	}

	private void loadTeacher(Student student) {
		Teacher teacher = new Teacher();
		teacher.setId(UUID.randomUUID().toString().replaceAll("-", ""));
		teacher.setName("王老师");
		teacher.setClassId("1");
		teacherDao.save(teacher);
		int i = 1 / 0;
		studentDao.save(student);
	}

}