package com.heike.action.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.heike.pojo.Employer;
import com.heike.service.EmployerService;
import com.opensymphony.xwork2.ActionSupport;

@Controller("adminAction")
@Scope("prototype")
public class AdminAction extends ActionSupport {
	private static final long serialVersionUID = -5240557669011012186L;

	@Autowired
	private EmployerService employerService;
	
	private Employer employer;
	
	/**
	 * 添加二级用户
	 * @return
	 * @throws Exception
	 */
	public String addEmployer() throws Exception {
		
		employerService.saveEmployer(employer);
		return "addEmployer";
	}

	public Employer getEmployer() {
		return employer;
	}
	public void setEmployer(Employer employer) {
		this.employer = employer;
	}
	
}
