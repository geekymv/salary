package com.heike.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.heike.dao.EmployerDAO;
import com.heike.pojo.Employer;
import com.heike.pojo.Student;

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


	@Override
	public Employer query(String number, String password) {
		
		String hql = "from Employer e where e.account = ? and e.password = ? ";
		
		return (Employer) getSession().createQuery(hql).
			setString(0, number).setString(1, password).uniqueResult();
		
	}


	@Override
	public List<Student> listStudent(Integer id) {
		
		Employer employer = (Employer) getSession().get(Employer.class, id);
		
		List<Student> students = new ArrayList<Student>();
		students.addAll(employer.getStudents());
		
		return students;
	}

}
