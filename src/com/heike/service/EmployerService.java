package com.heike.service;

import java.util.List;

import com.heike.pojo.Employer;
import com.heike.pojo.Recruit;
import com.heike.pojo.Student;
import com.heike.utils.PageUtil;

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
	
	
	/**
	 * 根据Employer的id分页查询Employer的招聘信息
	 * @param id
	 * @param page
	 * @param pageSize
	 * @return
	 */
	public PageUtil<Recruit> getRecruitsByPage(Integer id,int page, int pageSize);
	
	/**
	 * 保存二级用户
	 * @param employer
	 */
	public void saveEmployer(Employer employer);

	/**
	 * 管理员列举所有的二级用户
	 * @param id
	 */
	public List<Employer> listEmployer(Integer id);
	
}
