package com.heike.dao;

import java.util.List;

import com.heike.pojo.Employer;
import com.heike.pojo.Recruit;
import com.heike.pojo.Student;
import com.heike.utils.PageUtil;

public interface EmployerDAO {
	/**
	 * 添加或更新
	 * @param employer
	 * @return
	 */
	public Employer saveOrUpdate(Employer employer);
	
	/**
	 * 根据学号和密码查询Employer
	 * @param number
	 * @param password
	 * @return
	 */
	public Employer query(String number, String password);
	
	/**
	 * 根据id查询Employer
	 * @param number
	 * @param password
	 * @return
	 */
	public Employer query(Integer empId);
	
	
	/**
	 * 查询所有
	 * @return
	 */
	public List<Employer> queryAll();
	
	/**
	 * 根据Employer的id分页查询Employer的招聘信息
	 * @param id
	 * @param page
	 * @param pageSize
	 * @return
	 */
	public PageUtil<Recruit> getRecruitsByPage(Integer id,int page, int pageSize);
	
	/**
	 * 根据Employer编号查询已经招聘的学生
	 * @param id
	 * @return
	 */
	public List<Student> listStudent(Integer id);
	
	
	

}
