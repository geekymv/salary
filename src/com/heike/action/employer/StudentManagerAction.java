package com.heike.action.employer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.heike.pojo.Student;
import com.heike.service.StudentService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 学生管理
 */
@Controller("studentManagerAction")
@Scope("prototype")
public class StudentManagerAction extends ActionSupport {
	private static final long serialVersionUID = -4660955332666540649L;
	
	@Autowired
	private StudentService studentService;
	
	private Student student;
	
	
}
