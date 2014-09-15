package com.heike.action.employer;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.heike.pojo.Employer;
import com.heike.pojo.Recruit;
import com.heike.pojo.Student;
import com.heike.service.EmployerService;
import com.heike.service.RecruitService;
import com.heike.utils.PageUtil;
import com.opensymphony.xwork2.ActionSupport;

@Controller("employerAction")
@Scope("prototype")
public class EmployerAction extends ActionSupport implements RequestAware, SessionAware {
	private static final long serialVersionUID = -3913472914242259117L;

	@Autowired
	private EmployerService employerService;
	
	@Autowired
	private RecruitService recruitService;

	private Integer id;	//招聘信息id
	private Recruit recruit;
	
	private Employer employer;
	
	private int page = 1;
	private PageUtil<Recruit> pageUtil;
	
	
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
	
	
	/**
	 * 显示Employer发布的招聘信息
	 * @return
	 * @throws Exception
	 */
	public String recruitList() throws Exception {
		
		employer = (Employer) session.get("employer");
		
		if(null == employer){
			return ERROR;
		}
		
		pageUtil = employerService.getRecruitsByPage(employer.getId(), page, 1);
		
		request.put("pageUtil", pageUtil);
		
		return "recruitList";
		
	}
	
	/**
	 * 查看招聘信息
	 * @return
	 * @throws Exception
	 */
	public String details() throws Exception {

		recruit = recruitService.get(id);
		
		request.put("recruit", recruit);
		
		return "details";
	}
	
	
	/**
	 * 显示所有已招聘的学生助理
	 * @return
	 * @throws Exception
	 */
	public String stuList() throws Exception {
		
		List<Student> students = employerService.listStudent(employer.getId());
		
		request.put("students", students);
		
		return "stuList";
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
