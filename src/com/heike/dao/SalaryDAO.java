package com.heike.dao;

import java.util.List;

import com.heike.pojo.Salary;

public interface SalaryDAO {
	
	/**
	 * 保存
	 * @param salary
	 */
	public void save(Salary salary);
	
	/**
	 * 根据部门id列出该部门学生的薪水
	 * @param empId
	 * @return
	 */
	public List<Salary> list(Integer empId);
	
}
