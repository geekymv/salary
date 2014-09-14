package com.heike.service;

import java.util.List;

import com.heike.pojo.Employer;
import com.heike.pojo.Student;

public interface EmployerService {
	
	/**
	 * 根据账号和密码，验证用户的合法性
	 * @param account
	 * @param password
	 * @return
	 */
	public Employer login(String account, String password);
	
	/**
	 * 根据Employer编号查询已经招聘的学生
	 * @param id
	 * @return
	 */
	public List<Student> listStudent(Integer id);
	
}
