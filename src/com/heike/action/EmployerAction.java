package com.heike.action;

import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.heike.pojo.Employer;
import com.heike.pojo.Recruit;
import com.heike.service.EmployerService;
import com.heike.service.RecruitService;
import com.opensymphony.xwork2.ActionSupport;

@Controller("employer")
public class EmployerAction extends ActionSupport implements RequestAware {
	private static final long serialVersionUID = -3913472914242259117L;

	@Autowired
	private EmployerService employerService;
	
	@Autowired
	private RecruitService recruitService;
	
	private Employer employer;
	private Recruit recruit;
	
	
	/**
	 * 发布招聘信息
	 * @return
	 * @throws Exception
	 */
	public String publish() throws Exception {
		
		employer.getRecruits().add(recruit);
		recruit.setEmployer(employer);
		
		recruitService.publish(recruit);
		
		
		return SUCCESS;
	}


	public Employer getEmployer() {
		return employer;
	}
	public void setEmployer(Employer employer) {
		this.employer = employer;
	}
	public Recruit getRecruit() {
		return recruit;
	}
	public void setRecruit(Recruit recruit) {
		this.recruit = recruit;
	}

	private Map<String, Object> request;
	
	@Override
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}
	

}
