package com.heike.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.heike.dao.StudentDAO;
import com.heike.dto.RecruitStudent;
import com.heike.pojo.Recruit;
import com.heike.pojo.Student;

@Repository("studentDAO")
public class StudentDAOImpl implements StudentDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession() {
		
		return sessionFactory.getCurrentSession();
	}
	
	
	@Override
	public Student save(Student student) {
		
		getSession().saveOrUpdate(student);
		
		return student;
	}

	@Override
	public Student query(String number) {
		
		String hql = "from Student s where s.number = ?";
		
		Student student = (Student) getSession().createQuery(hql)
				.setString(0, number).uniqueResult();

		
		return student;
	}


	@Override
	public Student query(String number, String password) {
		
		String hql = "from Student s where s.number = ? and s.password = ? ";
		
		return (Student) getSession().createQuery(hql).
			setString(0, number).setString(1, password).uniqueResult();
	}

	@Override
	public Student query(Integer id) {

		return (Student) getSession().get(Student.class, id);
	}


	@Override
	public List<RecruitStudent> listRecruitStudent(Integer id) {
		List<RecruitStudent> students = new ArrayList<RecruitStudent>();
		
		Student student = (Student) getSession().get(Student.class, id);
		Set<RecruitStudent> recruitStudents = student.getRecruitStudents();
		
		students.addAll(recruitStudents);

		return students;
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<RecruitStudent> listApproveJob(Integer id) {
	
		String hql = "from RecruitStudent rs where rs.student.id=? and rs.status=1";
		
		return (List<RecruitStudent>)getSession().createQuery(hql).setInteger(0, id).list();
	}

}
















