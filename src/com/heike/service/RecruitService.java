package com.heike.service;

import java.util.List;

import com.heike.dto.RecruitStudent;
import com.heike.pojo.Recruit;
import com.heike.pojo.Student;
import com.heike.utils.PageUtil;

public interface RecruitService {
	
	/**
	 * 添加招聘信息
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
	 * 根据Recruit的id获取报名信息
	 * @param id
	 * @return
	 */
	public List<RecruitStudent> listRecruitStudent(Integer id);
	
	/**
	 * 查看该学生是否报名了该招聘
	 * @param recId
	 * @param stuId
	 * @return true已报名, false未报名
	 */
	public boolean isApply(Integer stuId, Integer recId);
	
	/**
	 * 审核学生招聘是否通过
	 * @param rs
	 */
	public void examineRecruit(Integer stuId, Integer recId, Integer status, Integer empId);

}
