package com.heike.action.admin;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.heike.dto.RecruitStudent;
import com.heike.pojo.Employer;
import com.heike.pojo.Recruit;
import com.heike.pojo.Salary;
import com.heike.pojo.Student;
import com.heike.service.RecruitService;
import com.heike.service.SalaryService;
import com.heike.utils.CreateExcel;
import com.heike.utils.SSHDateConverter;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 下载Excel
 */
@Controller("downloadExcelAction")
@Scope("prototype")
public class DownloadExcelAction extends ActionSupport{
	private static final long serialVersionUID = -4688945224880167732L;
	
	@Autowired
	private SalaryService salaryService;
	@Autowired
	private RecruitService recruitService;
	
	private InputStream excelStream;
	
	private String filename;
	
	public String loadSalary() throws Exception {
		String[] titles = {"序号", "姓名", "学号", "年级专业", "岗位", "工作时间/h", "基本工资", "工具费", "奖金", "实发工资", "学院", "备注"};

		SSHDateConverter converter = new SSHDateConverter();
		String date = converter.convertToString(null, new Date());
		filename = "学生勤工助学工资表" + date + ".xls";
		filename = new String(filename.getBytes("gbk"), "iso-8859-1");

		//数据
		List<Salary> salarys = salaryService.listAll(9);
		List<Recruit> recruits = new ArrayList<Recruit>();
		for(Salary s : salarys){
			//根据stuId和empId得到RecruitStudent
			Student student = s.getStudent();
			Employer employer = s.getEmployer();
			RecruitStudent rs = recruitService.queryRecruitStudent2(student.getId(), employer.getId());

			Recruit recruit = rs.getRecruit();	
			
			recruits.add(recruit);
		}
		
		excelStream = CreateExcel.getExcelInputStream(titles, salarys, recruits);
		
		return "loadSalary";
	}
	
	
	
	
	public InputStream getExcelStream() {
		return excelStream;
	}
	public void setExcelStream(InputStream excelStream) {
		this.excelStream = excelStream;
	}

	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}    
	
}















