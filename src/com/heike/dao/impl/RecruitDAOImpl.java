package com.heike.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.heike.dao.RecruitDAO;
import com.heike.pojo.Recruit;

@Repository("recruitDAO")
public class RecruitDAOImpl implements RecruitDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	
	@Override
	public Recruit save(Recruit recruit) {

		getSession().saveOrUpdate(recruit);
		
		return recruit;
	}

}
