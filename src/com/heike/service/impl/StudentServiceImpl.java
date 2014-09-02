package com.heike.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heike.dao.StudentDAO;
import com.heike.pojo.Student;
import com.heike.service.StudentService;

@Service("studentService")
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDAO studentDAO;
	
	@Override
	public Student register(Student student) {

		return studentDAO.saveOrUpdate(student);
	}

	@Override
	public Student login(String account, String password) {
		
		return studentDAO.query(account, password);
	}

}
