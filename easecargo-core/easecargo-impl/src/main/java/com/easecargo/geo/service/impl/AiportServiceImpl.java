package com.easecargo.geo.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.easecargo.general.service.impl.CodeMasterServiceImpl;
import com.easecargo.geo.Airport;
import com.easecargo.geo.dao.AirportDao;
import com.easecargo.geo.service.AirportService;

@Service("AiportService")
public class AiportServiceImpl implements AirportService {
	
	Logger logger = LoggerFactory.getLogger(CodeMasterServiceImpl.class);

	@Autowired
	AirportDao airportDao;
	
	public AiportServiceImpl() {
	}

	@Override
	@Transactional(readOnly = false)
	public void saveAirport(Airport apt) {
		airportDao.saveAirport(apt);
	}

	@Override
	@Transactional(readOnly = false)
	public void deleteAirport(Airport apt) {
		airportDao.deleteAirport(apt);
	}

	@Override
	public List<Airport> getAll() {
		return airportDao.selectAll();
	}
	@Override
	public List<Airport> getAirportsByName(String airportName) {
		return airportDao.selectAirportsByName(airportName);
	}
	@Override
	public Airport getAirportByCode(String airportCode) {
		return airportDao.selectAirportByCode(airportCode);

	}
	@Override
	public List<Airport> getAirportsInCity(String cityCode) {
		return airportDao.selectAirportsInCity(cityCode);
	}
	@Override
	public List<Airport> getAirportsInCountry(String countryCode) {
		return airportDao.selectAirportsInCountry(countryCode);
	}
}
