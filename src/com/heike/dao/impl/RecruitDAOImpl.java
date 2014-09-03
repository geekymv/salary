package com.heike.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.heike.dao.RecruitDAO;
import com.heike.pojo.Recruit;
import com.heike.utils.PageUtil;

@Repository("recruitDAO")
public class RecruitDAOImpl implements RecruitDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	
	@Override
	public Recruit save(Recruit recruit) {

		getSession().saveOrUpdate(recruit);
		
		return recruit;
	}


	@Override
	public PageUtil<Recruit> getRecruitsByPage(int page, int pageSize) {
		
		PageUtil<Recruit> pageUtil = new PageUtil<Recruit>();
		
		int rowCounts = getRowCounts();
		
		pageUtil.getTotalPage(rowCounts, pageSize);	//计算总页数
		
		String hql = "from Recruit";
		
		@SuppressWarnings("unchecked")
		List<Recruit> recruits = getSession().createQuery(hql)	//
								.setFirstResult((page-1)*pageSize).setMaxResults(pageSize).list();
		
		pageUtil.setDatas(recruits);
		
		
		return pageUtil;
	}


	@Override
	public int getRowCounts() {
		
//		int rowCounts = getSession().createQuery("from Recruit").list().size();
		
		long rowCounts = (Long) getSession().	//
					createQuery("select count(*) from Recruit").uniqueResult();
		
		return Integer.valueOf(String.valueOf(rowCounts));
	}

}
