package com.heike.pojo;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 学生类
 * @author Geek_ymv
 */
@Entity
@Table(name="t_student")
public class Student {
	
	private Integer id;
	private Integer number;	//学号
	private String password;
	private String name;
	private String gender;
	private String college;	//学院
	private String profession;	//专业
	private String mobile;
	
	private Set<Employer> employers = new LinkedHashSet<Employer>();	//Student与Employer是多对多的关联关系(双向)

	private Set<Salary> salarys = new LinkedHashSet<Salary>();	//一对多的关联关系，Salary是多的一方
	
	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}
	
	//由多的一方维护关联关系(只有OneToOne,OneToMany,ManyToMany上才有mappedBy属性)，student是多的一方Salary的属性
	@OneToMany(mappedBy="student")	
	public Set<Salary> getSalarys() {
		return salarys;
	}
	
	@ManyToMany(mappedBy="students")	//由Employer维护关联关系
	public Set<Employer> getEmployers() {
		return employers;
	}
	
	public void setSalarys(Set<Salary> salarys) {
		this.salarys = salarys;
	}
	public void setEmployers(Set<Employer> employers) {
		this.employers = employers;
	}
	public Integer getNumber() {
		return number;
	}
	public String getPassword() {
		return password;
	}
	public String getName() {
		return name;
	}
	public String getGender() {
		return gender;
	}
	public String getCollege() {
		return college;
	}
	public String getProfession() {
		return profession;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setProfession(String profession) {
		this.profession = profession;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", number=" + number + ", password="
				+ password + ", name=" + name + ", gender=" + gender
				+ ", college=" + college + ", profession=" + profession
				+ ", mobile=" + mobile + "]";
	}
	
	
}








