package com.syh.demo.multi.datasource.jta.dao.test01;

import com.syh.demo.multi.datasource.jta.entity.Student;
import com.syh.demo.multi.datasource.jta.mapper.test01.StudentMapper;
import org.springframework.stereotype.Component;

/**
 * @author HSY
 */
@Component
public class StudentDao {

	private final StudentMapper studentMapper;

	public StudentDao(StudentMapper studentMapper) {
		this.studentMapper = studentMapper;
	}

	public void save(Student student) {
		studentMapper.save(student);
	}
}
