package com.heike.dao;

import com.heike.pojo.Salary;

public interface SalaryDAO {
	
	/**
	 * 根据学生学号查询该学生的薪水
	 * @param stuId
	 * @return
	 */
	public Salary query(Integer stuId);
	

}
