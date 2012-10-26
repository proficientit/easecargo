package com.easecargo.geo.dao;

import java.util.List;

import com.easecargo.geo.Airport;

public interface AirportDao {
	public void saveAirport(Airport apt);
	public void deleteAirport(Airport apt);
	public List<Airport> selectAll();
	public List<Airport> selectAirportsByName(String airportName) ;
	public Airport selectAirportByCode(String airportCode) ;
	public List<Airport> selectAirportsInCity(String cityCode) ;
	public List<Airport> selectAirportsInCountry(String countryCode) ;
}
