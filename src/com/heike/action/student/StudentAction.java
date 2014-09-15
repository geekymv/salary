package com.heike.action.student;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.heike.pojo.Recruit;
import com.heike.pojo.Student;
import com.heike.service.RecruitService;
import com.heike.service.StudentService;
import com.heike.utils.PageUtil;
import com.opensymphony.xwork2.ActionSupport;

@Controller("studentAction")
@Scope("prototype")
public class StudentAction extends ActionSupport implements SessionAware, RequestAware{
	private static final long serialVersionUID = -9121763308525676529L;
	
	@Autowired
	private RecruitService recruitService;
	
	@Autowired
	private StudentService studentService;
	
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
		if(null == student){
			return ERROR;
		}
		
		request.put("student", student);

		return "stuInfo";
		
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
		request.put("recruit", recruit);
		
		return "details";
	}
	
	/**
	 * 学生报名工作
	 * @return
	 * @throws Exception
	 */
	public String applyJob() throws Exception {
		student = (Student) session.get("student");
		if(null == student) {
			return ERROR;
		}
		
		recruit = recruitService.get(recruit.getId());
		
		//判断该生是否已经申请了该工作
		boolean find = recruit.getStudents().contains(student);
		if(find){	//包含该生
			System.out.println("你已经报过名了！！！");
			return "applyed";
		}	
		
		studentService.applyJob(student, recruit);
		return "applyJob";
	}
	
	/**
	 * 查看该学生报名哪些工作
	 * @return
	 * @throws Exception
	 */
	public String listJob() throws Exception {
		student = (Student) session.get("student");
		if(null == student) {
			return ERROR;
		}
		
		List<Recruit> recruits = studentService.listRecruit(student.getId());
		request.put("recruits", recruits);
		
		return "listJob";
	}

	/**
	 * 查看审核通过的工作
	 * @return
	 */
	public String approveJob() throws Exception {
		
		
		
		
		return "approve";
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
