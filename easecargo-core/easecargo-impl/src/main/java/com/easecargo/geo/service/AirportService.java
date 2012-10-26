package com.easecargo.geo.service;

import java.util.List;

import com.easecargo.geo.Airport;

public interface AirportService {
	public void saveAirport(Airport apt);
	public void deleteAirport(Airport apt);
	public List<Airport> getAll();
	/**
	 * ariportName like "airportName"
	 * 
	 * @param airportName
	 * @return
	 */
	public List<Airport> getAirportsByName(String airportName) ;
	public Airport getAirportByCode(String airportCode) ;
}
