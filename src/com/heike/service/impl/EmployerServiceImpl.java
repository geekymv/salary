package com.heike.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heike.dao.EmployerDAO;
import com.heike.pojo.Employer;
import com.heike.pojo.Student;
import com.heike.service.EmployerService;

@Service("employerService")
public class EmployerServiceImpl implements EmployerService{

	@Autowired
	private EmployerDAO employerDAO;
	
	
	
	@Override
	public Employer login(String account, String password) {
		
		return employerDAO.query(account, password);
	}

	@Override
	public List<Student> listStudent(Integer id) {
		
		return employerDAO.listStudent(id);
	}
	
	
	

}
