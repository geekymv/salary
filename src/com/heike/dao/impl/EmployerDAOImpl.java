package com.heike.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.heike.dao.EmployerDAO;
import com.heike.pojo.Employer;

@Repository("employerDAO")
public class EmployerDAOImpl implements EmployerDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	
	@Override
	public Employer saveOrUpdate(Employer employer) {
		getSession().saveOrUpdate(employer);
		return employer;
	}

	@Override
	public List<Employer> queryAll() {
		
		@SuppressWarnings("unchecked")
		List<Employer> employers = getSession().createQuery("from Employer").list();
		
		return employers;
	}

}
