/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.easecargo.awb;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Table;

/**
 * 
 * @author T2326
 */
@Entity
@Table(name = "ACOUNT_INFO")
public class AccountInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ACT_ID")
	private Integer accountId;

	@ManyToOne(fetch = FetchType.EAGER,cascade =CascadeType.ALL)
	@JoinColumn(name = "AWB_ID", nullable = false)
	private AWB awb;
	@Column(name = "ACOUNT_IDEN")
	private String accountIdentity;
	@Column(name = "ACOUNT_INFO")
	private String accountInformation;

	public AccountInfo() {
		super();
	}

	public AccountInfo(String accountIdentity, String accountInformation) {
		super();
		this.accountIdentity = accountIdentity;
		this.accountInformation = accountInformation;
	}

	/**
	 * @return the accountId
	 */
	public Integer getAccountId() {
		return accountId;
	}

	/**
	 * @param accountId
	 *            the accountId to set
	 */
	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	/**
	 * @return the awb
	 */
	public AWB getAwb() {
		return awb;
	}

	/**
	 * @param awb
	 *            the awb to set
	 */
	public void setAwb(AWB awb) {
		this.awb = awb;
	}

	/**
	 * @return the accountIdentity
	 */
	public String getAccountIdentity() {
		return accountIdentity;
	}

	/**
	 * @param accountIdentity
	 *            the accountIdentity to set
	 */
	public void setAccountIdentity(String accountIdentity) {
		this.accountIdentity = accountIdentity;
	}

	/**
	 * @return the accountInformation
	 */
	public String getAccountInformation() {
		return accountInformation;
	}

	/**
	 * @param accountInformation
	 *            the accountInformation to set
	 */
	public void setAccountInformation(String accountInformation) {
		this.accountInformation = accountInformation;
	}

}
