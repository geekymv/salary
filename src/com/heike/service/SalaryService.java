package com.heike.service;

import java.util.List;

import com.heike.pojo.Salary;

public interface SalaryService {	
	
	/**
	 * 根据学生学号查询该学生的薪水
	 * @param stuId
	 * @return
	 */
	public Salary query(Integer stuId);
	
	/**
	 * 发工资
	 * @param salary
	 */
	public void add(List<String> ids, List<Float> salarys, Integer month);

}
