package com.heike.action;

import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.heike.pojo.Recruit;
import com.heike.pojo.Student;
import com.heike.service.RecruitService;
import com.heike.utils.PageUtil;
import com.opensymphony.xwork2.ActionSupport;

@Controller("recruitAction")
@Scope("prototype")
public class RecruitAction extends ActionSupport implements SessionAware, RequestAware {
	private static final long serialVersionUID = 6350175517297697212L;

	private Integer id;	//招聘信息id
	
	@Autowired
	private RecruitService recruitService;
	
	private int page = 1;
	private PageUtil<Recruit> pageUtil;
	
	private Recruit recruit;
	
	/**
	 * 分页显示招聘信息
	 * @return
	 * @throws Exception
	 */
	public String list() throws Exception {

		Student student = (Student) session.get("student");
		
		if(null != student){
			
			pageUtil = recruitService.getRecruits(page, 4);
			System.out.println(pageUtil.getDatas());
			
			request.put("pageUtil", pageUtil);
			
			
			return "student";
		}
		
		
		return ERROR;
	}
	
	
	/**
	 * 查看招聘信息
	 * @return
	 * @throws Exception
	 */
	public String details() throws Exception {

		recruit = recruitService.get(id);

		System.out.println(recruit);
		
		request.put("recruit", recruit);
		
		return "details";
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
	
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getId() {
		return id;
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

	public Recruit getRecruit() {
		return recruit;
	}
	public void setRecruit(Recruit recruit) {
		this.recruit = recruit;
	}

}
