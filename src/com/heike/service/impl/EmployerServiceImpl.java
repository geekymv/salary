package com.heike.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heike.dao.EmployerDAO;
import com.heike.pojo.Employer;
import com.heike.pojo.Recruit;
import com.heike.pojo.Student;
import com.heike.service.EmployerService;
import com.heike.utils.PageUtil;

@Service("employerService")
public class EmployerServiceImpl implements EmployerService{

	@Autowired
	private EmployerDAO employerDAO;
	
	@Override
	public Employer login(String account, String password) {
		return employerDAO.query(account, password);
	}

	@Override
	public List<Student> listStudent(Integer id) {
		return employerDAO.listStudent(id);
	}

	@Override
	public PageUtil<Recruit> getRecruitsByPage(Integer id, int page,
			int pageSize) {
		return employerDAO.getRecruitsByPage(id, page, pageSize);
	}

	@Override
	public void saveEmployer(Employer employer) {
		
		employerDAO.save(employer);
	}

	@Override
	public List<Employer> listEmployer(Integer id) {
		
		return employerDAO.listEmployer(id);
	}

	@Override
	public Employer queryEmployer(Integer id) {
		
		return employerDAO.query(id);
	}

}
