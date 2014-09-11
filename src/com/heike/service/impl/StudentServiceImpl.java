package com.heike.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heike.dao.RecruitDAO;
import com.heike.dao.StudentDAO;
import com.heike.pojo.Recruit;
import com.heike.pojo.Student;
import com.heike.service.StudentService;

@Service("studentService")
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDAO studentDAO;
	
	@Autowired
	private RecruitDAO recruitDAO;
	
	
	@Override
	public Student register(Student student) {

		return studentDAO.save(student);
	}

	@Override
	public Student login(String account, String password) {
		
		return studentDAO.query(account, password);
	}

	@Override
	public boolean applyJob(Student student, Recruit recruit) {

		boolean flag = true;
		
		try {
			recruit.getStudents().add(student);
			student.getRecruits().add(recruit);
			
			recruit.setApplyNum(recruit.getApplyNum()+1);
			
			recruitDAO.save(recruit);
			studentDAO.save(student);
			
		} catch (Exception e) {
			flag = false;
			e.printStackTrace();
		}
		
		return flag;
	}

	@Override
	public List<Recruit> listRecruit(Integer id) {
		
		List<Recruit> recruits = new ArrayList<Recruit>();
		
		Set<Recruit> rs = studentDAO.query(id).getRecruits();
		
		recruits.addAll(rs);
		
		return recruits;
	}

}
















