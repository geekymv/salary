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
	public Student query(String number) {
		return null;
	}


	@Override
	public Student query(String number, String password) {
		
		String hql = "from Student s where s.number = ? and s.password = ? ";
		
		return (Student) getSession().createQuery(hql).
			setString(0, number).setString(1, password).uniqueResult();
	}

}
