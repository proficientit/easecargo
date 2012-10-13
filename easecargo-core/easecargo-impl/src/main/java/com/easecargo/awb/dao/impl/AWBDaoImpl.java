package com.easecargo.awb.dao.impl;

import java.util.List;


import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.easecargo.awb.AWB;
import com.easecargo.awb.dao.AWBDao;


@Repository("AWBDao")
@Transactional
public class AWBDaoImpl implements AWBDao {

	Logger logger = LoggerFactory.getLogger(AWBDaoImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		logger.info("SessionFactory injecting");
		this.sessionFactory = sessionFactory;
	}

	@Transactional(readOnly = false)
	@Override
	public void saveAWB(AWB awb) {
		logger.info("Saving AWB");
		sessionFactory.getCurrentSession().saveOrUpdate(awb);
	}

	@Transactional(readOnly = false)
	@Override
	public void deleteAWB(AWB awb) {
		logger.info("Deleting AWB");
		sessionFactory.getCurrentSession().delete(awb);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AWB> getAllAWBs() {
		logger.info("get All awbs");
		return (List<AWB>) sessionFactory.getCurrentSession()
				.createQuery("from AWB").list();
	}

	@Override
	public AWB selectAWBById(Integer awbId) {
		logger.info("select AWB by Id");
		return (AWB) sessionFactory.getCurrentSession().get(AWB.class, awbId);
	}
	@SuppressWarnings("unchecked")
	@Override
	public AWB selectAWBByIdAndUserId(Integer awbId, Integer userId) {
		logger.info("select AWB by Id");
		Query query = sessionFactory.getCurrentSession().createQuery
				(" from AWB where awbId = :awbId and user.userId=:userId");
		query.setParameter("awbId", awbId);
		query.setParameter("userId", userId);
		
		List<AWB> awbList = query.list();
		//assuming awbNumber is unique
		if(awbList !=null && awbList.size()>0) {
			return awbList.get(0);	
		} else	return null;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<AWB> selectAllAWBByUserId( Integer userId) {
		logger.info("select AWB by Id");
		Query query = sessionFactory.getCurrentSession().createQuery
				(" from AWB where user.userId=:userId");
		query.setParameter("userId", userId);
		
		return query.list();
	
	}

	@SuppressWarnings("unchecked")
	@Override
	public AWB selectAWBByNumber(Integer awbPrefix, Integer awbNum) {
		logger.info("select AWB by Num");
		Query query = sessionFactory.getCurrentSession().createQuery
				(" from AWB where awbNumber = :awbNum and awbPrefix=:awbPrefix");
		query.setParameter("awbPrefix", awbPrefix);
		query.setParameter("awbNum", awbNum);
		
		List<AWB> awbList = query.list();
		//assuming awbNumber is unique
		if(awbList !=null && awbList.size()>0) {
			return awbList.get(0);	
		} else	return null;
		

	}	
	@SuppressWarnings("unchecked")
	@Override	
	public AWB selectAWBByNumberAndUserId(Integer awbPrefix, Integer awbNum, Integer userId){
		logger.info("select AWB by Num");
		Query query = sessionFactory.getCurrentSession().createQuery
				(" from AWB where awbNumber = :awbNum and awbPrefix=:awbPrefix and user.userId=:userId");
		query.setParameter("awbPrefix", awbPrefix);
		query.setParameter("awbNum", awbNum);
		query.setParameter("userId", userId);
		
		
		List<AWB> awbList = query.list();
		//assuming awbNumber is unique
		if(awbList !=null && awbList.size()>0) {
			return awbList.get(0);
			
		} else return null;
			
	}
}
