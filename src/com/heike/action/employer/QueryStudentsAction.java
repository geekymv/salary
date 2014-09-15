package com.heike.action.employer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.heike.pojo.Student;
import com.heike.service.RecruitService;
import com.opensymphony.xwork2.ActionSupport;

@Controller("QueryStudentsAction")
@Scope("prototype")
public class QueryStudentsAction extends ActionSupport {
	private static final long serialVersionUID = -6433575204294237287L;

	@Autowired
	private RecruitService recruitService;

	// 招聘信息的id
	private Integer id;

	private List<Student> students;

	/**
	 * 查看某条招聘信息所有报名的学生
	 */
	@Override
	public String execute() throws Exception {

		System.out.println(id);

		students = recruitService.listStudent(id);

		return SUCCESS;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}

}
