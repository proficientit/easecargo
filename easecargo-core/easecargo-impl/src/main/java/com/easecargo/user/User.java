package com.easecargo.user;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MST_USER")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "USER_ID")
	private Integer userId;
	@Column(name="CUS_SALUT")
	private String salutation;
	@Column(name="FRST_NAM")
	private String firstName;
	@Column(name="LST_NAM")
	private String lastName;
	@Column(name="DEF_CURR")
	private String defaultCurrency;
	@Column(name="DEF_CTY")
	private String defaultCity;
	@Column(name="DEF_SIGN")
	private String defaultSign;
	@Column(name="CPY_EMAIL")
	private String email;
	
	@Column(name = "USER_Name")
	private String userName; //mail id
	
	public User() {
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getSalutation() {
		return salutation;
	}

	public void setSalutation(String salutation) {
		this.salutation = salutation;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDefaultCurrency() {
		return defaultCurrency;
	}

	public void setDefaultCurrency(String defaultCurrency) {
		this.defaultCurrency = defaultCurrency;
	}

	public String getDefaultCity() {
		return defaultCity;
	}

	public void setDefaultCity(String defaultCity) {
		this.defaultCity = defaultCity;
	}

	public String getDefaultSign() {
		return defaultSign;
	}

	public void setDefaultSign(String defaultSign) {
		this.defaultSign = defaultSign;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	

}
