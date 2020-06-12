package com.syh.demo.multi.data.source.controller;

import com.syh.demo.multi.data.source.entity.Student;
import com.syh.demo.multi.data.source.entity.Teacher;
import com.syh.demo.multi.data.source.service.StudentService;
import com.syh.demo.multi.data.source.service.TeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * 多数据源事务测试
 * 
 * @author acer
 *
 */
@RestController
@Api(tags = "多数据源")
public class TransactionController {

	private final StudentService studentService;
	private final  TeacherService teacherService;

	public TransactionController(StudentService studentService,
								 TeacherService teacherService) {
		this.studentService = studentService;
		this.teacherService = teacherService;
	}

	@PostMapping("/student")
	public String saveStudent(@RequestBody Student student) {
		student.setId(UUID.randomUUID().toString().replaceAll("-", ""));
		studentService.saveStudent(student);
		return "success";
	}

	@PostMapping("/teacher")
	public String saveTeacher(@RequestBody Teacher teacher) {
		teacher.setId(UUID.randomUUID().toString().replaceAll("-", ""));
		teacherService.saveTeacher(teacher);
		return "success";
	}

	@ApiOperation(value = "开始事务测试：结果是一个插入进去了，属于非正常现象")
	@PostMapping("/test")
	public String test(@RequestBody Student student) {
		student.setId(UUID.randomUUID().toString().replaceAll("-", ""));
		studentService.saveStudent2(student);
		return "success";
	}


	@ApiOperation(value = "开始事务测试：结果是两个都没法插入---属于正常现象")
	@PostMapping("/test2")
	public String test2(@RequestBody Student student) {
		student.setId(UUID.randomUUID().toString().replaceAll("-", ""));
		studentService.saveStudent3(student);
		return "success";
	}

	@ApiOperation(value = "开始事务测试：结果是一个插入进去了，属于非正常现象")
	@PostMapping("/test3")
	public String test3(@RequestBody Student student) {
		student.setId(UUID.randomUUID().toString().replaceAll("-", ""));
		studentService.saveStudent4(student);
		return "success";
	}
}
