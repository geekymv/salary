package com.heike.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heike.dao.SalaryDAO;
import com.heike.pojo.Salary;
import com.heike.service.SalaryService;

@Service("salaryService")
public class SalaryServiceImpl implements SalaryService {

	@Autowired
	private SalaryDAO salaryDAO;
	
	
	@Override
	public Salary query(Integer stuId) {

		return salaryDAO.query(stuId);
	}


	@Override
	public void add(Salary salary) {
		
		salaryDAO.save(salary);
	}

}
