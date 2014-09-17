package com.heike.action.employer;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.heike.pojo.Employer;
import com.heike.service.SalaryService;
import com.opensymphony.xwork2.ActionSupport;

@Controller("payoffAction")
@Scope("prototype")
public class PayoffAction extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = 5159830980480774192L;

	@Autowired
	private SalaryService salaryService;

	private List<String> ids;
	private List<Float> salarys;
	private Integer month;
	
	
	public String payoff() throws Exception {
		Employer employer = (Employer) session.get("employer");
		if(null == employer){
			return ERROR;
		}
		
		System.out.println(ids);
		System.out.println("salary = " + salarys);
		System.out.println("month = " + month);
		
		salaryService.add(ids, salarys, month);
		
		return "payoff";
	}

	public List<String> getIds() {
		return ids;
	}
	public void setIds(List<String> ids) {
		this.ids = ids;
	}
	public List<Float> getSalarys() {
		return salarys;
	}
	public void setSalarys(List<Float> salarys) {
		this.salarys = salarys;
	}
	public Integer getMonth() {
		return month;
	}
	public void setMonth(Integer month) {
		this.month = month;
	}
	
	private Map<String, Object> session;
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
}
