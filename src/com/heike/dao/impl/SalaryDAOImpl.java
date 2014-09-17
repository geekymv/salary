package com.heike.dao.impl;

import org.hibernate.Query;
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
	public Salary query(Integer stuId) {
		
		Query query = getSession().createQuery("from Salary s where s.student.id = ?");
		
		return (Salary) query.setInteger(0, stuId).uniqueResult();
	}

	@Override
	public void save(Salary salary) {
		
		getSession().saveOrUpdate(salary);
	}

}
