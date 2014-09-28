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

/**
 * 批量给学生发薪水
 */
@Controller("payoffAction")
@Scope("prototype")
public class PayoffAction extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = 5159830980480774192L;

	@Autowired
	private SalaryService salaryService;

	private List<String> ids;	//学生和用工单位的id
	private List<Float> salarys;	//基本工资
	private List<Float> toolfees;	//工具费
	private List<Float> bonus;	//奖金
	private List<String> remarks;	//备注
	
	private Integer month;
	
	
	public String payoff() throws Exception {
		Employer employer = (Employer) session.get("employer");
		if(null == employer){
			return ERROR;
		}
		
		System.out.println("month = " + month);
		System.out.println(ids);
		System.out.println("salary = " + salarys);
		System.out.println("toolfees = " + toolfees);
		System.out.println("bonus = " + bonus);
		System.out.println("remarks = " + remarks);
		
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
	public List<Float> getToolfees() {
		return toolfees;
	}
	public void setToolfees(List<Float> toolfees) {
		this.toolfees = toolfees;
	}
	public List<Float> getBonus() {
		return bonus;
	}
	public void setBonus(List<Float> bonus) {
		this.bonus = bonus;
	}
	public List<String> getRemarks() {
		return remarks;
	}
	public void setRemarks(List<String> remarks) {
		this.remarks = remarks;
	}

	private Map<String, Object> session;
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
}
