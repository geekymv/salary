package com.heike.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.heike.pojo.Recruit;
import com.heike.pojo.Student;

/**
 * Student和Recruit之间的辅助实体类
 * @author Geek_ymv
 */
@Entity
@Table(name="t_recruit_student")
public class RecruitStudent {
	
	
	private Long id;
	private Integer status;	//0表示在审核，1表示审核通过，-1表示审核未通过

	private Recruit recruit;

	private Student student;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	@ManyToOne
	@JoinColumn(name="rec_id", nullable=true)
	public Recruit getRecruit() {
		return recruit;
	}
	public void setRecruit(Recruit recruit) {
		this.recruit = recruit;
	}
	
	@ManyToOne
	@JoinColumn(name="stu_id", nullable=true)
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
}















