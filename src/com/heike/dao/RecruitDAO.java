package com.heike.dao;

import com.heike.pojo.Recruit;
import com.heike.utils.PageUtil;

public interface RecruitDAO {
	
	/**
	 * 保存
	 * @param recruit
	 * @return
	 */
	public Recruit save(Recruit recruit);
	
	/**
	 * 分页查询招聘信息
	 * @return
	 */
	public PageUtil<Recruit> getRecruitsByPage(int page, int pageSize);
	
	/**
	 * 获得招聘信息表中的总记录数
	 * @return
	 */
	public int getRowCounts();
	
	
}
