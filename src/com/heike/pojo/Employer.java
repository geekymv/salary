package com.heike.pojo;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 用工单位类(学生处和学院)
 * @author Geek_ymv
 */
@Entity
@Table(name="t_employer")
public class Employer {
	
	private Integer id;
	private String account;	//账号
	private String password;
	private String name;
	private String mobile;
	private float totalMoney;	//申请月总金额
	private Integer postNum;	//申请的岗位数
	private Integer authority;	//权限（1--学生处， 2--学院或社团）
	private String remarks;		//备注
	private boolean examine;	//审核是否通过
	
	private Set<Student> students = new LinkedHashSet<Student>();
	
	private Set<Recruit> recruits = new LinkedHashSet<Recruit>();	//Employer与Recruit是一对多的关联关系
	
	
	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@ManyToMany
	@JoinTable(name="t_employer_student",
			joinColumns={@JoinColumn(name="emp_id")},
			inverseJoinColumns={@JoinColumn(name="stu_id")}	//Employer维护关联关系
			)
	public Set<Student> getStudents() {
		return students;
	}
	
	@OneToMany(mappedBy="employer")
	public Set<Recruit> getRecruits() {
		return recruits;
	}
	public void setRecruits(Set<Recruit> recruits) {
		this.recruits = recruits;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public float getTotalMoney() {
		return totalMoney;
	}
	public void setTotalMoney(float totalMoney) {
		this.totalMoney = totalMoney;
	}
	public Integer getPostNum() {
		return postNum;
	}
	public void setPostNum(Integer postNum) {
		this.postNum = postNum;
	}
	public Integer getAuthority() {
		return authority;
	}
	public void setAuthority(Integer authority) {
		this.authority = authority;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public boolean isExamine() {
		return examine;
	}
	public void setExamine(boolean examine) {
		this.examine = examine;
	}
	

}













