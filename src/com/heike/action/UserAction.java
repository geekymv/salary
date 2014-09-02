package com.heike.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.heike.pojo.Employer;
import com.heike.pojo.Student;
import com.heike.service.EmployerService;
import com.heike.service.StudentService;
import com.opensymphony.xwork2.ActionSupport;

@Controller("user")
@Scope("prototype")
public class UserAction extends ActionSupport implements SessionAware{
	private static final long serialVersionUID = 837098305141530374L;

	@Autowired
	private StudentService studentService;
	
	@Autowired
	private EmployerService employerService;
	
	private String account;
	private String password;
	
	private String repassword;
	private Student student;
	
	private Employer employer;
	
	
	/**
	 * 用户登录验证
	 * @return
	 * @throws Exception
	 */
	public String login() throws Exception {
	
		employer = employerService.login(account, password);
		
		if(null != employer){
			
			System.out.println("emp...");
			
			session.put("employer", employer);
			
			return "employer";
		}
		
		student = studentService.login(account, password);
		
		if(null != student){
			
			System.out.println("stu...");
			
			session.put("student", student);
			return "student";
		}
		
		return INPUT;
	}
	
	/**
	 * 用户注册
	 * @return
	 * @throws Exception
	 */
	public String register() throws Exception {

		studentService.register(student);
		
		return SUCCESS;
	}
	
	
	private Map<String, Object> session;
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRepassword() {
		return repassword;
	}
	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Student getStudent() {
		return student;
	}
	public void setEmployer(Employer employer) {
		this.employer = employer;
	}
	public Employer getEmployer() {
		return employer;
	}

}






