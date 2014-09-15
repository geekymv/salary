package com.heike.pojo;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.struts2.json.annotations.JSON;

/**
 * 学生类
 * @author Geek_ymv
 */
@Entity
@Table(name="t_student")
public class Student {
	
	private Integer id;
	private String number;	//学号
	private String password;
	private String name;
	private String gender;
	private String college;	//学院
	private String profession;	//专业
	private String mobile;
	private String introduce;	//自我介绍
	private Date regTime;	//注册时间
	
	private Set<Employer> employers = new LinkedHashSet<Employer>();	//Student与Employer是多对多的关联关系(双向)

	private Set<Salary> salarys = new LinkedHashSet<Salary>();	//一对多的关联关系，Salary是多的一方
	
	private Set<Recruit> recruits = new LinkedHashSet<Recruit>();
	
	

	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}
	
	//由多的一方维护关联关系(只有OneToOne,OneToMany,ManyToMany上才有mappedBy属性)，student是多的一方Salary的属性
	@OneToMany(mappedBy="student")	
	@JSON(serialize=false)
	public Set<Salary> getSalarys() {
		return salarys;
	}
	
	@ManyToMany(mappedBy="students")	//由Employer维护关联关系
	@JSON(serialize=false)
	public Set<Employer> getEmployers() {
		return employers;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	public Date getRegTime() {
		return regTime;
	}
	@ManyToMany(mappedBy="students", fetch=FetchType.EAGER)
	@JSON(serialize=false)
	public Set<Recruit> getRecruits() {
		return recruits;
	}

	public void setRecruits(Set<Recruit> recruits) {
		this.recruits = recruits;
	}
	
	public void setRegTime(Date regTime) {
		this.regTime = regTime;
	}

	public void setSalarys(Set<Salary> salarys) {
		this.salarys = salarys;
	}
	public void setEmployers(Set<Employer> employers) {
		this.employers = employers;
	}
	public String getNumber() {
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
	public void setNumber(String number) {
		this.number = number;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setProfession(String profession) {
		this.profession = profession;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((number == null) ? 0 : number.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", number=" + number + ", password="
				+ password + ", name=" + name + ", gender=" + gender
				+ ", college=" + college + ", profession=" + profession
				+ ", mobile=" + mobile + ", regTime=" + regTime + "]";
	}
	
}








