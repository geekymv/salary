package com.heike.action.admin;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.heike.pojo.Employer;
import com.heike.service.EmployerService;
import com.heike.utils.ConstantUtils;
import com.heike.utils.EncryptUtil;
import com.opensymphony.xwork2.ActionSupport;

@Controller("adminAction")
@Scope("prototype")
public class AdminAction extends ActionSupport implements RequestAware, SessionAware {
	private static final long serialVersionUID = -5240557669011012186L;

	@Autowired
	private EmployerService employerService;
	
	private Employer employer;
	
	private Integer empId;
	
	/**
	 * 添加二级用户
	 * @return
	 * @throws Exception
	 */
	public String addEmployer() throws Exception {
		Employer admin = (Employer) session.get("employer");
		if(null == admin || admin.getAuthority() != ConstantUtils.ADMIN) {
			return ERROR;
		}
		
		if(null == employer.getId()) {	//添加
			employer.setAuthority(2);	//设置二级用户权限
			employer.setExamine(true);
			
			String password = EncryptUtil.md5Encrypt(employer.getPassword());
			employer.setPassword(password);
			
			String remarks = employer.getRemarks();	//备注信息
			
			if(remarks == null || remarks.trim().equals("")){
				employer.setRemarks("无");
			}
		}
		
		employerService.saveEmployer(employer);
		
		return "addEmployer";
	}
	public String preAddEmployer() throws Exception {
		return "preAddEmployer";
	}
	
	/**
	 * 管理员修改二级用户的信息
	 * @return
	 * @throws Exception
	 */
	public String updateEmployer() throws Exception {
		
		employer = employerService.queryEmployer(empId);
		
		request.put("employer", employer);
		
		return "updateEmployer";
	}
	
	
	/**
	 * 管理员列举所有的二级用户
	 * @return
	 * @throws Exception
	 */
	public String listEmployer() throws Exception {
		
		Employer admin = (Employer) session.get("employer");
		if(null == admin || admin.getAuthority() != ConstantUtils.ADMIN) {
			return ERROR;
		}
		
		List<Employer> employers = employerService.listEmployer(admin.getId());
		
		request.put("employers", employers);
		
		return "listEmployer";
	}
	
	/**
	 * 跳转到工资下载页面
	 * @return
	 * @throws Exception
	 */
	public String preLoadSalary() throws Exception {
		
		return "preLoadSalary";
	}
	
	
	public Employer getEmployer() {
		return employer;
	}
	public void setEmployer(Employer employer) {
		this.employer = employer;
	}
	
	private Map<String, Object> session;
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	private Map<String, Object> request;
	@Override
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}

	public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	
}
