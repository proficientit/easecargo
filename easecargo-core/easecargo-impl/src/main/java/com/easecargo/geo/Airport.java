package com.easecargo.geo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import static javax.persistence.GenerationType.IDENTITY;


@Entity
@Table(name = "MST_APT")
public class Airport implements Serializable {

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;

	public Airport() {
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "MSTAPT_ID")
	private Integer airportId;
	
	@Column(name = "APT_COD")
	private String airportCode;
	@Column(name = "APT_NAM")
	private String airportName;
	@Column(name = "CTY_COD")
	private String cityCode;
	@Column(name = "CTY_NAM")
	private String cityName;
	@Column(name = "CNTRY_COD")
	private String countryCode;
	@Column(name = "CNTRY_NAM")
	private String countryName;

	public Integer getAirportId() {
		return airportId;
	}
	public void setAirportId(Integer airportId) {
		this.airportId = airportId;
	}
	public String getAirportCode() {
		return airportCode;
	}
	public void setAirportCode(String airportCode) {
		this.airportCode = airportCode;
	}
	public String getAirportName() {
		return airportName;
	}
	public void setAirportName(String airportName) {
		this.airportName = airportName;
	}
	public String getCityCode() {
		return cityCode;
	}
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	
}
