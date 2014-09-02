package com.heike.dao;

import com.heike.pojo.Student;

public interface StudentDAO {
	
	/**
	 * 添加或更新用户
	 * @param student
	 * @return
	 */
	public Student saveOrUpdate(Student student);

	/**
	 * 根据学生学号查询
	 * @param number
	 * @return
	 */
	public Student query(Integer number);
	
}
