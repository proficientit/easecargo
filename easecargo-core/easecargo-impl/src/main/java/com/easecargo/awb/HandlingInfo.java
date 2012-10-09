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
@Table(name = "HNDL_INFO")
public class HandlingInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "HNDL_ID")
	private Integer handlingId;

	@ManyToOne(fetch = FetchType.EAGER,cascade =CascadeType.ALL)
	@JoinColumn(name = "AWB_ID", nullable = false)
	private AWB awb;
	@Column(name = "HNDL_CAT")
	private String handlignCategory;
	@Column(name = "SVC_TYP_COD")
	private String serviceTypeCode;
	@Column(name = "SVC_TYP_TXT")
	private String serviceTypeText;

	public HandlingInfo() {
		super();
	}

	public HandlingInfo(String handlignCategory, String serviceTypeCode,
			String serviceTypeText) {
		super();
		this.handlignCategory = handlignCategory;
		this.serviceTypeCode = serviceTypeCode;
		this.serviceTypeText = serviceTypeText;
	}

	/**
	 * @return the handlingId
	 */
	public Integer getHandlingId() {
		return handlingId;
	}

	/**
	 * @param handlingId
	 *            the handlingId to set
	 */
	public void setHandlingId(Integer handlingId) {
		this.handlingId = handlingId;
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
	 * @return the handlignCategory
	 */
	public String getHandlignCategory() {
		return handlignCategory;
	}

	/**
	 * @param handlignCategory
	 *            the handlignCategory to set
	 */
	public void setHandlignCategory(String handlignCategory) {
		this.handlignCategory = handlignCategory;
	}

	/**
	 * @return the serviceTypeCode
	 */
	public String getServiceTypeCode() {
		return serviceTypeCode;
	}

	/**
	 * @param serviceTypeCode
	 *            the serviceTypeCode to set
	 */
	public void setServiceTypeCode(String serviceTypeCode) {
		this.serviceTypeCode = serviceTypeCode;
	}

	/**
	 * @return the serviceTypeText
	 */
	public String getServiceTypeText() {
		return serviceTypeText;
	}

	/**
	 * @param serviceTypeText
	 *            the serviceTypeText to set
	 */
	public void setServiceTypeText(String serviceTypeText) {
		this.serviceTypeText = serviceTypeText;
	}

}
