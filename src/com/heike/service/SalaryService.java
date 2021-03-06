package com.heike.service;

import java.util.List;

import com.heike.pojo.Salary;

public interface SalaryService {	
	
	/**
	 * 根据部门id列出该部门学生的薪水
	 * @param empId
	 * @return
	 */
	public List<Salary> list(Integer empId);
	
	
	/**
	 * 发工资
	 * @param salary
	 */
	public void add(List<String> ids, List<Float> salarys, Integer month);
	
	
	/**
	 * 根据月份得到所有学生的工资表
	 * @param month
	 * @return
	 */
	public List<Salary> listAll(Integer month);

}
