/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.easecargo.awb;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.easecargo.user.User;

/**
 * @author T2326
 */
@Entity
@Table(name = "MST_CUST")
public class Customer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "MSTCUST_ID")
	private Integer cutomerId;

	@Column(name = "ACN_NUM")
	private String accountNumber;
	@Column(name = "CUS_NAME")
	private String customerName;

	@Column(name = "CONT_NAME")
	private String contactName;

	@Column(name = "ADRS_LINE")
	private String address;

	@Column(name = "PO_BOX")
	private Integer poBox;

	@Column(name = "CTY_NAMR")
	private String cityName;

	@Column(name = "CNTY_NAME")
	private String countryName;

	@Column(name = "CNTY_CODE")
	private String countryCode;

	@Column(name = "phoneNumber")
	private Integer phoneNumber;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "TELEX_ADRS")
	private String telexAddress;

	@Column(name = "FAX_NUM")
	private Integer faxNum;

	@Column(name = "AGT_IATA_COD")
	private Integer agentIATACode;

	@Column(name = "AGT_IATA_CASS_COD")
	private Integer agentIATACASSCode;

	@Column(name="CUS_TYP")
	private String customerType;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID", nullable = false)
	private User user;
	
	public Customer() {
		super();
	}

	public Customer(String accountNumber, String customerName,
			String contactName, String address, Integer poBox, String cityName,
			String countryName, String countryCode, Integer phoneNumber,
			String email, String telexAddress, Integer faxNum,
			Integer agentIATACode, Integer agentIATACASSCode, String customerType) {
		super();
		this.accountNumber = accountNumber;
		this.customerName = customerName;
		this.contactName = contactName;
		this.address = address;
		this.poBox = poBox;
		this.cityName = cityName;
		this.countryName = countryName;
		this.countryCode = countryCode;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.telexAddress = telexAddress;
		this.faxNum = faxNum;
		this.agentIATACode = agentIATACode;
		this.agentIATACASSCode = agentIATACASSCode;
		this.customerType = customerType;
	}

	/**
	 * @return the cutomerId
	 */
	public Integer getCutomerId() {
		return cutomerId;
	}

	/**
	 * @param cutomerId
	 *            the cutomerId to set
	 */
	public void setCutomerId(Integer cutomerId) {
		this.cutomerId = cutomerId;
	}

	/**
	 * @return the accountNumber
	 */
	public String getAccountNumber() {
		return accountNumber;
	}

	/**
	 * @param accountNumber
	 *            the accountNumber to set
	 */
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	/**
	 * @return the customerName
	 */
	public String getCustomerName() {
		return customerName;
	}

	/**
	 * @param customerName
	 *            the customerName to set
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	/**
	 * @return the contactName
	 */
	public String getContactName() {
		return contactName;
	}

	/**
	 * @param contactName
	 *            the contactName to set
	 */
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address
	 *            the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the poBox
	 */
	public Integer getPoBox() {
		return poBox;
	}

	/**
	 * @param poBox
	 *            the poBox to set
	 */
	public void setPoBox(Integer poBox) {
		this.poBox = poBox;
	}

	/**
	 * @return the cityName
	 */
	public String getCityName() {
		return cityName;
	}

	/**
	 * @param cityName
	 *            the cityName to set
	 */
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	/**
	 * @return the countryName
	 */
	public String getCountryName() {
		return countryName;
	}

	/**
	 * @param countryName
	 *            the countryName to set
	 */
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	/**
	 * @return the countryCode
	 */
	public String getCountryCode() {
		return countryCode;
	}

	/**
	 * @param countryCode
	 *            the countryCode to set
	 */
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	/**
	 * @return the phoneNumber
	 */
	public Integer getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param phoneNumber
	 *            the phoneNumber to set
	 */
	public void setPhoneNumber(Integer phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the telexAddress
	 */
	public String getTelexAddress() {
		return telexAddress;
	}

	/**
	 * @param telexAddress
	 *            the telexAddress to set
	 */
	public void setTelexAddress(String telexAddress) {
		this.telexAddress = telexAddress;
	}

	/**
	 * @return the faxNum
	 */
	public Integer getFaxNum() {
		return faxNum;
	}

	/**
	 * @param faxNum
	 *            the faxNum to set
	 */
	public void setFaxNum(Integer faxNum) {
		this.faxNum = faxNum;
	}

	public Integer getAgentIATACode() {
		return agentIATACode;
	}

	public void setAgentIATACode(Integer agentIATACode) {
		this.agentIATACode = agentIATACode;
	}

	public Integer getAgentIATACASSCode() {
		return agentIATACASSCode;
	}

	public void setAgentIATACASSCode(Integer agentIATACASSCode) {
		this.agentIATACASSCode = agentIATACASSCode;
	}

	public String getCustomerType() {
		return customerType;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}



	public User getUser() {
		return user;
	}




	public void setUser(User user) {
		this.user = user;
	}
	

}
