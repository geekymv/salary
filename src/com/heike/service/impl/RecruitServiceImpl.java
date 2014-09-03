package com.heike.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heike.dao.RecruitDAO;
import com.heike.pojo.Recruit;
import com.heike.service.RecruitService;
import com.heike.utils.PageUtil;

@Service("recruitService")
public class RecruitServiceImpl implements RecruitService {

	@Autowired
	private RecruitDAO recruitDAO;
	
	@Override
	public Recruit publish(Recruit recruit) {
		
		return recruitDAO.save(recruit);
	}

	
	@Override
	public PageUtil<Recruit> getRecruits(int page, int pageSize) {
		
		return recruitDAO.getRecruitsByPage(page, pageSize);
	}


	@Override
	public Recruit get(Integer id) {
		
		return recruitDAO.query(id);
	}

}
