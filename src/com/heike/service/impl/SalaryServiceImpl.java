package com.heike.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heike.dao.EmployerDAO;
import com.heike.dao.SalaryDAO;
import com.heike.dao.StudentDAO;
import com.heike.pojo.Employer;
import com.heike.pojo.Salary;
import com.heike.pojo.Student;
import com.heike.service.SalaryService;

@Service("salaryService")
public class SalaryServiceImpl implements SalaryService {

	@Autowired
	private SalaryDAO salaryDAO;
	@Autowired
	private StudentDAO studentDAO;
	@Autowired
	private EmployerDAO employerDAO;
	
	@Override
	public void add(List<String> ids, List<Float> salarys, Integer month) {

		if(null == ids || null == salarys || ids.size() != ids.size() ){
			return;
		}
		
		for(int i = 0; i < ids.size(); i++){
			
			String[] idString = ids.get(i).split("&&");
			
			Integer stuId = Integer.valueOf(idString[0].trim());
			Integer empId = Integer.valueOf(idString[1].trim());
			Float salary = salarys.get(i);
//			
//			System.out.println("stuId = " + stuId);
//			System.out.println("empId = " + empId);
//			System.out.println("salary = " + salary);
//			System.out.println("month = " + month);
//			
//			System.out.println("------------------------------------");
			
			Student student = studentDAO.query(stuId);
			Employer employer = employerDAO.query(empId);
			
			Salary s = new Salary();
			
			s.setStudent(student);
			s.setEmployer(employer);
			s.setSalary(salary);
			s.setMonth(month);
			
			s.setDate(new Date());

			salaryDAO.save(s);
		}
	}

	@Override
	public List<Salary> list(Integer empId) {
		
		return salaryDAO.list(empId);
	}

	

}
