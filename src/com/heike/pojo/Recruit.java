package com.heike.pojo;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 招聘信息类
 * @author Geek_ymv
 */
@Entity
@Table(name="t_recruit")
public class Recruit {
	
	private Integer id;
	private String title;
	private String postName;	//招聘岗位名
	private Integer postNum;	//招聘岗位数
	private float salary;	//薪水
	private Date releaseDate;	//发布时间
	private Integer applyNum;		//已报名人数
	private Date endDate;	//报名截止时间
	private String remarks;	//备注
	
	private Employer employer; //用工单位
	
	private Set<Student> students = new LinkedHashSet<Student>();	//Recruit与Student是多对多的关联关系(单向)
	

	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}
	
	@ManyToOne
	@JoinColumn(name="emp_id")
	public Employer getEmployer() {
		return employer;
	}
	
	@ManyToMany
	@JoinTable(name="t_recruit_student", joinColumns={@JoinColumn(name="rec_id")},
			inverseJoinColumns={@JoinColumn(name="stu_id")}	//Recruit维护关联关系
			)
	public Set<Student> getStudents() {
		return students;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	public void setEmployer(Employer employer) {
		this.employer = employer;
	}
	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPostName() {
		return postName;
	}
	public void setPostName(String postName) {
		this.postName = postName;
	}
	public Integer getPostNum() {
		return postNum;
	}
	public void setPostNum(Integer postNum) {
		this.postNum = postNum;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	public Date getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	public Integer getApplyNum() {
		return applyNum;
	}
	public void setApplyNum(Integer applyNum) {
		this.applyNum = applyNum;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}
