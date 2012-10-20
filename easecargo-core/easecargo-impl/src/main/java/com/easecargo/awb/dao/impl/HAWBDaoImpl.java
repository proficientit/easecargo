package com.easecargo.awb.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.easecargo.awb.HAWB;
import com.easecargo.awb.dao.HAWBDao;


@Repository("HAWBDao")
@Transactional
public class HAWBDaoImpl  implements HAWBDao{

	Logger logger = LoggerFactory.getLogger(HAWBDaoImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		logger.info("SessionFactory injecting");
		this.sessionFactory = sessionFactory;
	}

	@Transactional(readOnly = false)
	@Override
	public void saveHAWB(HAWB hawb) {
		logger.info("Saving HAWB");
		sessionFactory.getCurrentSession().saveOrUpdate(hawb);
	}

	@Transactional(readOnly = false)
	@Override
	public void deleteHAWB(HAWB hawb) {
		logger.info("Deleting hAWB");
		sessionFactory.getCurrentSession().delete(hawb);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<HAWB> getAllHAWBs() {
		logger.info("get All hawbs");
		return (List<HAWB>) sessionFactory.getCurrentSession()
				.createQuery("from HAWB").list();
	}

	@Override
	public HAWB selectHAWBById(Integer hawbId) {
		logger.info("select HAWB by Id");
		HAWB hawb = (HAWB) sessionFactory.getCurrentSession().get(HAWB.class, hawbId);
		
		if(hawb !=null) {
	
			Query query = sessionFactory.getCurrentSession().createQuery
					("select a.awbPrefix, a.awbNumber, a.totalPieces, a.totalGrossWeight, a.totalGrossWeightUnit, a.totalShipmentGrossCount from AWB a, HAWB h where a.awbId = h.awb.id and h.hawbId=:hawbId");
			query.setParameter("hawbId", hawbId);
			@SuppressWarnings("unchecked")
			List<Object[]> awbList =  (List<Object[]>)query.list();
			if(awbList !=null && awbList.size() >0) {//if null return null otherwise get AWB fields for completing screen
				Object[] o = awbList.get(0);
				logger.info("");
				logger.info(o[0]+""+o[1]+""+o[2]+""+o[3]+""+o[4]+""+o[5]);
				logger.info("");
				hawb.setAwbPrefix((Integer)o[0]);
				hawb.setAwbNumber((Integer)o[1]);
				hawb.setTotalPieces((Integer)o[2]);
				hawb.setTotalGrossWeight((Float)o[3]);
				hawb.setTotalGrossWeightUnit((String)o[4]);
				hawb.setTotalShipmentGrossCount((Integer)o[5]);
			
			}
		}
		return hawb;
		
	}
	@SuppressWarnings("unchecked")
	@Override
	public HAWB selectHAWBByNumberAndUserId(String hawbNum, Integer userId) {
		logger.info("select HAWB by Num");
		HAWB hawb = null;
		Query query1 = sessionFactory.getCurrentSession().createQuery
				("from HAWB ha where ha.hawbNum = :hawbNum and user.userId= :userId");
		query1.setParameter("hawbNum", hawbNum);
		query1.setParameter("userId", userId);
		List<HAWB> hawbList =  query1.list();
		if(hawbList !=null && hawbList.size()>0) //assuming hawbNum is unique 
			hawb = hawbList.get(0);	
		if(hawb !=null) { //if null return null otherwise get AWB fields for completing screen
			Query query = sessionFactory.getCurrentSession().createQuery
					("select a.awbPrefix, a.awbNumber, a.totalPieces, a.totalGrossWeight, a.totalGrossWeightUnit, a.totalShipmentGrossCount from AWB a, HAWB h where a.awbId = h.awb.id and h.hawbId=:hawbId");
			query.setParameter("hawbId", hawb.getHawbId());
			List<Object[]> awbList =  (List<Object[]>)query.list();
			if(awbList !=null && awbList.size() >0) {
				Object[] o = awbList.get(0);
				logger.info("");
				logger.info(o[0]+""+o[1]+""+o[2]+""+o[3]+""+o[4]+""+o[5]);
				logger.info("");
				hawb.setAwbPrefix((Integer)o[0]);
				hawb.setAwbNumber((Integer)o[1]);
				hawb.setTotalPieces((Integer)o[2]);
				hawb.setTotalGrossWeight((Float)o[3]);
				hawb.setTotalGrossWeightUnit((String)o[4]);
				hawb.setTotalShipmentGrossCount((Integer)o[5]);
			
			}
		}
		return hawb;
		
	}	
	@SuppressWarnings("unchecked")
	@Override	
	public HAWB selectHAWBByAWBPrefixAndNumberAndUserID(Integer awbPrefix, Integer awbNumber, Integer userId){
		logger.info("select HAWB by awb numb and prefix");
		HAWB hawb = null;
		Query query1 = sessionFactory.getCurrentSession().createQuery
				("from HAWB ha where  user.userId=:userId and awb.awbPrefix = :awbPrefix and awb.awbNumber = :awbNumber");
		query1.setParameter("userId", userId);
		query1.setParameter("awbPrefix", awbPrefix);
		query1.setParameter("awbNumber", awbNumber);
		List<HAWB> hawbList =  query1.list();
		if(hawbList !=null && hawbList.size()>0) //assuming hawbNum is unique 
			hawb = hawbList.get(0);	
		if(hawb !=null) { //if null return null otherwise get AWB fields for completing screen
			Query query = sessionFactory.getCurrentSession().createQuery
					("select a.awbPrefix, a.awbNumber, a.totalPieces, a.totalGrossWeight, a.totalGrossWeightUnit, a.totalShipmentGrossCount from AWB a, HAWB h where a.awbId = h.awb.id and h.hawbId=:hawbId");
			query.setParameter("hawbId", hawb.getHawbId());
			List<Object[]> awbList =  (List<Object[]>)query.list();
			if(awbList !=null && awbList.size() >0) {
				Object[] o = awbList.get(0);
				logger.info("");
				logger.info(o[0]+""+o[1]+""+o[2]+""+o[3]+""+o[4]+""+o[5]);
				logger.info("");
				hawb.setAwbPrefix((Integer)o[0]);
				hawb.setAwbNumber((Integer)o[1]);
				hawb.setTotalPieces((Integer)o[2]);
				hawb.setTotalGrossWeight((Float)o[3]);
				hawb.setTotalGrossWeightUnit((String)o[4]);
				hawb.setTotalShipmentGrossCount((Integer)o[5]);
			
			}
		}
		return hawb;		
	}
	
}
