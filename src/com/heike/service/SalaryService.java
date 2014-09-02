package com.heike.service;

import com.heike.pojo.Salary;

public interface SalaryService {	
	
	/**
	 * 根据学生学号查询该学生的薪水
	 * @param stuId
	 * @return
	 */
	public Salary query(Integer stuId);
	
	

}
