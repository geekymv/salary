package com.heike.action.employer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.heike.action.SalaryAction;
import com.opensymphony.xwork2.ActionSupport;

@Controller("payoffAction")
@Scope("prototype")
public class PayoffAction extends ActionSupport {
	private static final long serialVersionUID = 5159830980480774192L;

	@Autowired
	private SalaryAction salaryAction;
	private List<String> data;
	
	private List<Float> salary;
	
	private Integer month;
	
	
	public String payoff() throws Exception {

		System.out.println("salary = " + salary);
		System.out.println("month = " + month);
		
		System.out.println(data);
		
		
		return "payoff";
	}


	public List<String> getData() {
		return data;
	}
	public void setData(List<String> data) {
		this.data = data;
	}


	public List<Float> getSalary() {
		return salary;
	}
	public void setSalary(List<Float> salary) {
		this.salary = salary;
	}
	public Integer getMonth() {
		return month;
	}
	public void setMonth(Integer month) {
		this.month = month;
	}
	
}
