package com.heike.action;

import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.heike.pojo.Recruit;
import com.heike.service.RecruitService;
import com.heike.utils.PageUtil;
import com.opensymphony.xwork2.ActionSupport;

@Controller("studentAction")
@Scope("prototype")
public class StudentAction extends ActionSupport implements SessionAware, RequestAware{
	private static final long serialVersionUID = -9121763308525676529L;
	
	@Autowired
	private RecruitService recruitService;
	
	private int page = 1;
	private PageUtil<Recruit> pageUtil;
	
	
	public String list() throws Exception {
		
		pageUtil = recruitService.getRecruits(page, 2);
		System.out.println(pageUtil.getDatas());
		
		request.put("pageUtil", pageUtil);
		
		
		return SUCCESS;
	}
	
	
	
	private Map<String, Object> session;
	private Map<String, Object> request;
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
	@Override
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}

	public PageUtil<Recruit> getPageUtil() {
		return pageUtil;
	}
	public void setPageUtil(PageUtil<Recruit> pageUtil) {
		this.pageUtil = pageUtil;
	}
	
}
