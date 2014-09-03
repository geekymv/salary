package com.heike.action;

import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.heike.pojo.Employer;
import com.heike.pojo.Recruit;
import com.heike.pojo.Student;
import com.heike.service.RecruitService;
import com.heike.utils.ConstantUtils;
import com.heike.utils.PageUtil;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 登录成功Action
 * @author Geek_ymv
 */
@Controller("loginSuccessAction")
@Scope("prototype")
public class LoginSuccessAction extends ActionSupport implements SessionAware, RequestAware{
	private static final long serialVersionUID = 274552440422174537L;

	@Autowired
	private RecruitService recruitService;
	
	private Student student;
	private Employer employer;
	
	
	private int page = 1;
	
	private PageUtil<Recruit> pageUtil;
	
	private Recruit recruit;
	
	/**
	 * 登录成功
	 * @return
	 * @throws Exception
	 */
	public String success() throws Exception {

		Object user = session.get("user");
		
		if(null == user) {
			return ERROR;
		}

		if(user instanceof Student){	//学生
			student = (Student)user;
			System.out.println("student....");
			
			pageUtil = recruitService.getRecruits(page, 3);
			System.out.println(pageUtil.getDatas());
			
			request.put("pageUtil", pageUtil);
			
			return "student";
			
		}else if (user instanceof Employer){
			
			employer = (Employer)user;
			
			System.out.println("employer....");
			
			Integer authority = employer.getAuthority();
			
			if(ConstantUtils.ADMIN == authority){	//admin
				return "admin";
			
			}else if (ConstantUtils.EMPLOYER == authority){	//学院或社团
				return "employer";
			}
		}
		
		return ERROR;
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

	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Employer getEmployer() {
		return employer;
	}
	public void setEmployer(Employer employer) {
		this.employer = employer;
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
