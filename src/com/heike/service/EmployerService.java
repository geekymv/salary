package com.heike.service;

import com.heike.pojo.Employer;

public interface EmployerService {
	
	/**
	 * 根据账号和密码，验证用户的合法性
	 * @param account
	 * @param password
	 * @return
	 */
	public Employer login(String account, String password);

}
