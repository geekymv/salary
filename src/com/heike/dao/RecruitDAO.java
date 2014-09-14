package com.heike.dao;

import java.util.List;

import com.heike.pojo.Recruit;
import com.heike.pojo.Student;
import com.heike.utils.PageUtil;

public interface RecruitDAO {
	
	/**
	 * 保存
	 * @param recruit
	 * @return
	 */
	public Recruit save(Recruit recruit);
	
	
	/**
	 * 通过id查询招聘信息
	 * @param id
	 * @return
	 */
	public Recruit query(Integer id);
	
	/**
	 * 根据Recruit的id获取报名的学生信息
	 * @param id
	 * @return
	 */
	public List<Student> listStudent(Integer id);
	
	
	/**
	 * 分页查询招聘信息
	 * @return
	 */
	public PageUtil<Recruit> getRecruitsByPage(int page, int pageSize);
	
//	/**
//	 * 查询所有招聘信息
//	 * @return
//	 */
//	public List<Recruit> list();
	
	/**
	 * 获得招聘信息表中的总记录数
	 * @return
	 */
	public int getRowCounts();
	
	
	
	
}
