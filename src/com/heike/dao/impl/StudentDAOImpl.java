package com.heike.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.heike.dao.StudentDAO;
import com.heike.pojo.Student;

@Repository("studentDAO")
public class StudentDAOImpl implements StudentDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession() {
		
		return sessionFactory.getCurrentSession();
	}
	
	
	@Override
	public Student saveOrUpdate(Student student) {
		
		getSession().saveOrUpdate(student);
		
		return student;
	}

	@Override
	public Student query(Integer number) {
		return null;
	}

}
