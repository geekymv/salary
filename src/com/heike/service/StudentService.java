package com.heike.service;

import com.heike.pojo.Student;

public interface StudentService {

	/**
	 * 注册用户
	 * @param student
	 * @return
	 */
	public Student register(Student student);
	
	/**
	 * 根据账号和密码，验证用户的合法性
	 * @param account
	 * @param password
	 * @return
	 */
	public Student login(String account, String password);
	
}
