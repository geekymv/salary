package com.heike.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heike.dao.RecruitDAO;
import com.heike.dao.StudentDAO;
import com.heike.dto.RecruitStudent;
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

			RecruitStudent rs = new RecruitStudent();
			rs.setStatus(0);	//等待审核
			
			rs.setStudent(student);
			rs.setRecruit(recruit);
			
			recruitDAO.applyJobt(rs);
			
			recruit.setApplyNum(recruit.getApplyNum()+1);
			
			recruitDAO.save(recruit);
			studentDAO.save(student);
			
		} catch (Exception e) {
			flag = false;
			e.printStackTrace();
		}
		
		return flag;
	}

//	@Override
//	public List<Recruit> listRecruit(Integer id) {
//		
//		List<Recruit> recruits = new ArrayList<Recruit>();
//		
//		Set<RecruitStudent> rStudents = studentDAO.query(id).getRecruitStudents();
//		
//		for(Iterator<RecruitStudent> iter = rStudents.iterator(); iter.hasNext(); ){
//			RecruitStudent rs = iter.next();
//			recruits.add(rs.getRecruit());
//		}
//		
//		return recruits;
//	}

	@Override
	public boolean validateStuNum(String number) {
		
		Student student = studentDAO.query(number);
		
		if(null == student) {	//不存在
			return false;
		}
		
		return true; //存在
	}

	@Override
	public List<RecruitStudent> listRecruitStudent(Integer id) {
		
		return studentDAO.listRecruitStudent(id);
	}

}
















