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
	 * 根据学号和密码查询学生
	 * @param number
	 * @param password
	 * @return
	 */
	public Student query(String number, String password);

	/**
	 * 根据学生学号查询
	 * @param number
	 * @return
	 */
	public Student query(String number);
	
}
