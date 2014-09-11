package com.heike.action;

import java.util.Date;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.heike.pojo.Employer;
import com.heike.pojo.Recruit;
import com.heike.service.EmployerService;
import com.heike.service.RecruitService;
import com.opensymphony.xwork2.ActionSupport;

@Controller("employerAction")
@Scope("prototype")
public class EmployerAction extends ActionSupport implements RequestAware, SessionAware {
	private static final long serialVersionUID = -3913472914242259117L;

	@Autowired
	private EmployerService employerService;
	
	@Autowired
	private RecruitService recruitService;
	
	private Recruit recruit;
	private Employer employer;
	
	
	/**
	 * 发布招聘信息
	 * @return
	 * @throws Exception
	 */
	public String publish() throws Exception {
		
		employer = (Employer) session.get("employer");

		if(null == employer) {
			return ERROR;
		}

		recruit.setReleaseDate(new Date());	//发布日期
		recruit.setEmployer(employer);
		
		recruitService.publish(recruit);	//保存招聘信息
		
		return "published";
	}

	
	/**
	 * 查看个人信息
	 * @return
	 * @throws Exception
	 */
	public String empInfo() throws Exception {
		
		employer = (Employer) session.get("employer");
		
		request.put("employer", employer);
		
		return "empInfo";
	}
	
	
	
	
	
	
	public Recruit getRecruit() {
		return recruit;
	}
	public void setRecruit(Recruit recruit) {
		this.recruit = recruit;
	}
	public Employer getEmployer() {
		return employer;
	}
	public void setEmployer(Employer employer) {
		this.employer = employer;
	}

	private Map<String, Object> request;
	private Map<String, Object> session;
	@Override
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
