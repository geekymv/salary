package com.heike.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.heike.pojo.Recruit;
import com.heike.pojo.Student;
import com.heike.service.RecruitService;
import com.opensymphony.xwork2.ActionSupport;

@Controller("recruitAction")
@Scope("prototype")
public class RecruitAction extends ActionSupport{
	private static final long serialVersionUID = 6350175517297697212L;
	
	@Autowired
	private RecruitService recruitService;
	private Recruit recruit;
	
	private Student student;
	
	
	
	
	
	

	public Recruit getRecruit() {
		return recruit;
	}
	public void setRecruit(Recruit recruit) {
		this.recruit = recruit;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	
}
