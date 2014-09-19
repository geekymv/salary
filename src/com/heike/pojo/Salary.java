package com.heike.pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 薪水类
 * @author Geek_ymv
 */
@Entity
@Table(name="t_salary")
public class Salary {
	
	private Integer id;
	private Date date;
	private Integer month;	//月份
	private float salary;	//基本工资
	private float bonus;	//奖金
	private float toolFee;	//工具费

	private Employer employer;
	private Student student;	//多对一的关联关系，Student是一的一方
	
	private String remarks;		//备注
	
	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}
	
	@ManyToOne
	@JoinColumn(name="stu_id")
	public Student getStudent() {
		return student;
	}
	@ManyToOne
	@JoinColumn(name="emp_id")
	public Employer getEmployer() {
		return employer;
	}
	public void setEmployer(Employer employer) {
		this.employer = employer;
	}
	public Date getDate() {
		return date;
	}
	public Integer getMonth() {
		return month;
	}
	@Column(columnDefinition="float default 0")
	public float getSalary() {
		return salary;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setMonth(Integer month) {
		this.month = month;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	@Column(columnDefinition="float default 0")
	public float getBonus() {
		return bonus;
	}
	public void setBonus(float bonus) {
		this.bonus = bonus;
	}
	@Column(columnDefinition="float default 0")
	public float getToolFee() {
		return toolFee;
	}
	public void setToolFee(float toolFee) {
		this.toolFee = toolFee;
	}

	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Override
	public String toString() {
		return "Salary [id=" + id + ", salary="
				+ salary + ", month=" + month + ", date=" + date + "]";
	}	
	
}
