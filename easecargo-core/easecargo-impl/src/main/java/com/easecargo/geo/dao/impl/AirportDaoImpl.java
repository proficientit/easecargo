package com.easecargo.geo.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.easecargo.general.dao.impl.CodeMasterDaoImpl;
import com.easecargo.geo.Airport;
import com.easecargo.geo.dao.AirportDao;

@Repository("AirportDao")
@Transactional
public class AirportDaoImpl implements AirportDao {

	Logger logger = LoggerFactory.getLogger(CodeMasterDaoImpl.class);

	@Autowired
	private SessionFactory sessionFactory;
	public AirportDaoImpl() {
	}

	@Override
	@Transactional(readOnly = false)
	public void saveAirport(Airport apt) {
		sessionFactory.getCurrentSession().saveOrUpdate(apt);
	}

	@Override
	@Transactional(readOnly = false)
	public void deleteAirport(Airport apt) {
		sessionFactory.getCurrentSession().delete(apt);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Airport> selectAll() {
		logger.info("get All Airport");
		return (List<Airport>) sessionFactory.getCurrentSession()
				.createQuery("from Airport").list();	
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Airport> selectAirportsByName(String airportName) {
		logger.info("get All Airport");
		airportName=airportName+"%";
		Query query = sessionFactory.getCurrentSession().createQuery
				(" from Airport where airportName like :airportName");
		query.setParameter("airportName", airportName);
		return query.list();	
	}	
	@Override
	@SuppressWarnings("unchecked")
	public Airport selectAirportByCode(String airportCode) {
		Query query = sessionFactory.getCurrentSession().createQuery
				(" from Airport where airportCode = :airportCode");
		query.setParameter("airportCode", airportCode);
		List<Airport> list = query.list();
		if(list!=null && list.size()>0)
			return list.get(0);
		else return null;
	}
	@Override
	@SuppressWarnings("unchecked")
	public List<Airport> selectAirportsInCity(String cityCode){
		logger.info("get All  AirportsInCity");
		Query query = sessionFactory.getCurrentSession().createQuery
				(" from Airport where cityCode = :cityCode");
		query.setParameter("cityCode", cityCode);
		return query.list();	
	}	
	@Override
	@SuppressWarnings("unchecked")
	public List<Airport> selectAirportsInCountry(String countryCode) {
		logger.info("get All  AirportsInCountry");
		Query query = sessionFactory.getCurrentSession().createQuery
				(" from Airport where countryCode = :countryCode");
		query.setParameter("countryCode", countryCode);
		return query.list();	
	}	

}
