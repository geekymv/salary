package com.heike.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.heike.pojo.Salary;
import com.heike.service.SalaryService;
import com.opensymphony.xwork2.ActionSupport;

@Controller("salaryAction")
@Scope("prototype")
public class SalaryAction extends ActionSupport{
	private static final long serialVersionUID = -8801819917309066294L;

	@Autowired
	private SalaryService salaryService;
	
	@Override
	public String execute() throws Exception {
		
		Salary salary = salaryService.query(1);

		System.out.println(salary);
		
		System.out.println(salary.getStudent());
		
		return SUCCESS;
	}
	
	
}
