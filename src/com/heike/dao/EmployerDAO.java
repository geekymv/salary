package com.heike.dao;

import java.util.List;

import com.heike.pojo.Employer;

public interface EmployerDAO {
	
	/**
	 * 添加或更新
	 * @param employer
	 * @return
	 */
	public Employer saveOrUpdate(Employer employer);
	
	/**
	 * 查询所有
	 * @return
	 */
	public List<Employer> queryAll();
	
	
	

}
