package com.heike.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.heike.dao.SalaryDAO;
import com.heike.pojo.Salary;

@Repository("salaryDAO")
public class SalaryDAOImpl implements SalaryDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void save(Salary salary) {
		getSession().save(salary);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Salary> list(Integer empId) {
		
		return (List<Salary>)getSession().createQuery("from Salary s where s.employer.id=?")	//
				.setInteger(0, empId).list();
	}

}
