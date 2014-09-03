package com.heike.service;

import com.heike.pojo.Recruit;
import com.heike.utils.PageUtil;

public interface RecruitService {
	
	/**
	 * 发布招聘信息
	 * @param recruit
	 * @return
	 */
	public Recruit publish(Recruit recruit);

	/**
	 * 分页查询招聘信息
	 * @param page	页号
	 * @param pageSize	每页显示的记录数
	 * @return
	 */
	public PageUtil<Recruit> getRecruits(int page, int pageSize);
	
	

}
