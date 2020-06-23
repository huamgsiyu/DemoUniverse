package com.syh.demo.multi.datasource.aop.service;

import com.syh.demo.multi.datasource.aop.entity.Student;
import com.syh.demo.multi.datasource.aop.entity.Teacher;
import com.syh.demo.multi.datasource.aop.mapper.test01.StudentMapper;
import com.syh.demo.multi.datasource.aop.mapper.test02.TeacherMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/**
 * @author HSY
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class StudentService {
	private final StudentMapper studentMapper;
	private final TeacherMapper teacherMapper;
	private final TeacherService teacherService;

	public StudentService(StudentMapper studentMapper, 
						  TeacherMapper teacherMapper, 
						  TeacherService teacherService) {
		this.studentMapper = studentMapper;
		this.teacherMapper = teacherMapper;
		this.teacherService = teacherService;
	}


	public void saveStudent(Student student) {
		studentMapper.save(student);
	}

	public void saveStudent2(Student student) {
		Teacher teacher = new Teacher();
		teacher.setId(UUID.randomUUID().toString().replaceAll("-", ""));
		teacher.setName("王老师");
		teacher.setClassId("1");
		teacherService.saveTeacher(teacher);
		int i = 1 / 0;
		studentMapper.save(student);
	}

	public void saveStudent3(Student student) {
		Teacher teacher = new Teacher();
		teacher.setId(UUID.randomUUID().toString().replaceAll("-", ""));
		teacher.setName("王老师");
		teacher.setClassId("1");
		teacherService.saveTeacher2(teacher);
		int i = 1 / 0;
		studentMapper.save(student);
	}

	public void saveStudent4(Student student) {
		Teacher teacher = new Teacher();
		teacher.setId(UUID.randomUUID().toString().replaceAll("-", ""));
		teacher.setName("王老师");
		teacher.setClassId("1");
		teacherMapper.save(teacher);
		int i = 1 / 0;
		studentMapper.save(student);
	}
}
