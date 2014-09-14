package com.heike.service;

import java.util.List;

import com.heike.pojo.Recruit;
import com.heike.pojo.Student;
import com.heike.utils.PageUtil;

public interface RecruitService {
	
	/**
	 * 发布招聘信息
	 * @param recruit
	 * @return
	 */
	public Recruit publish(Recruit recruit);

	
	/**
	 * 通过id查询招聘信息
	 * @param id
	 * @return
	 */
	public Recruit get(Integer id);
	
	/**
	 * 分页查询招聘信息
	 * @param page	页号
	 * @param pageSize	每页显示的记录数
	 * @return
	 */
	public PageUtil<Recruit> getRecruits(int page, int pageSize);
	
	/**
	 * 根据Recruit的id获取报名的学生信息
	 * @param id
	 * @return
	 */
	public List<Student> listStudent(Integer id);

}
