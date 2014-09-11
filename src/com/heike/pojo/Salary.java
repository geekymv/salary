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
	private float salary;

	private Student student;	//多对一的关联关系，Student是一的一方

	
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
	
	@Override
	public String toString() {
		return "Salary [id=" + id + ", salary="
				+ salary + ", month=" + month + ", date=" + date + "]";
	}	
	
}
