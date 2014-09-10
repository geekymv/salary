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

@Controller("studentAction")
@Scope("prototype")
public class StudentAction extends ActionSupport implements SessionAware, RequestAware{
	private static final long serialVersionUID = -9121763308525676529L;
	
	@Autowired
	private RecruitService recruitService;
	
	private Integer id;	//招聘信息id
	
	private int page = 1;
	private PageUtil<Recruit> pageUtil;
	
	private Recruit recruit;
	
	private Student student;
	
	/**
	 * 分页显示招聘信息
	 * @return
	 * @throws Exception
	 */
	public String listRecruit() throws Exception {

		student = (Student) session.get("student");
		
		if(null == student){
			return ERROR;
		}
	
		pageUtil = recruitService.getRecruits(page, 4);
		System.out.println(pageUtil.getDatas());
		
		request.put("pageUtil", pageUtil);
		
		return "listRecruit";
	}

	/**
	 * 查看学生信息
	 * @return
	 * @throws Exception
	 */
	public String stuInfo() throws Exception {

		student = (Student) session.get("student");
		
		System.out.println(student);
		
		request.put("student", student);

		return "stuInfo";
		
	}
	
	
	/**
	 * 查看该学生报名哪些工作
	 * @return
	 * @throws Exception
	 */
	public String listJob() throws Exception {
		
		return "listJob";
	}
	
	
	
	/**
	 * 查看招聘信息
	 * @return
	 * @throws Exception
	 */
	public String details() throws Exception {

		student = (Student) session.get("student");
		
		if(null == student){
			return ERROR;
		}
		
		
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

	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	
}
