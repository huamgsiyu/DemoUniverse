package com.syh.demo.multi.data.source.controller;

import com.syh.demo.multi.data.source.entity.Student;
import com.syh.demo.multi.data.source.entity.Teacher;
import com.syh.demo.multi.data.source.service.StudentService;
import com.syh.demo.multi.data.source.service.TeacherService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * 多数据源事务测试
 * 
 * @author acer
 *
 */
@RestController
public class TransactionController {

	private final StudentService studentService;
	private final  TeacherService teacherService;

	public TransactionController(StudentService studentService,
								 TeacherService teacherService) {
		this.studentService = studentService;
		this.teacherService = teacherService;
	}

	@RequestMapping("/savetest.do")
	public String saveStudent() {
		Student student = new Student();
		student.setId(UUID.randomUUID().toString().replaceAll("-", ""));
		student.setScore(100);
		student.setClassId("1");
		student.setUserId("hsy");
		studentService.saveStudent(student);
		return "success";
	}

	@RequestMapping("/saveteacher.do")
	public String saveTeacher() {
		Teacher teacher = new Teacher();
		teacher.setId(UUID.randomUUID().toString().replaceAll("-", ""));
		teacher.setName("苍老师");
		teacher.setClassId("1");
		teacherService.saveTeacher(teacher);
		return "success";
	}

	// ########################开始事务测试##########################
	/**
	 * 结果是一个插入进去了，属于非正常现象
	 * 
	 * @return
	 */
	@RequestMapping("/test.do")
	public String test() {
		Student student = new Student();
		student.setId(UUID.randomUUID().toString().replaceAll("-", ""));
		student.setScore(70);
		student.setClassId("1");
		student.setUserId("a");
		studentService.saveStudent2(student);
		return "success";
	}

	/**
	 * 结果是两个都没法插入---属于正常现象
	 * 
	 * @return
	 */
	@RequestMapping("/test2.do")
	public String test2() {
		Student student = new Student();
		student.setId(UUID.randomUUID().toString().replaceAll("-", ""));
		student.setScore(70);
		student.setClassId("1");
		student.setUserId("a");
		studentService.saveStudent3(student);
		return "success";
	}

	/**
	 * 结果是一个插入进去了，属于非正常现象
	 * 
	 * @return
	 */
	@RequestMapping("/test3.do")
	public String test3() {
		Student student = new Student();
		student.setId(UUID.randomUUID().toString().replaceAll("-", ""));
		student.setScore(70);
		student.setClassId("1");
		student.setUserId("a");
		studentService.saveStudent4(student);
		return "success";
	}
}
