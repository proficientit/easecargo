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
@Table(name = "OTH_CHRG")
public class OtherCharges implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "OTHCHRG_ID")
	private Integer otherChargesId;

	@ManyToOne(fetch = FetchType.EAGER,cascade =CascadeType.ALL)
	@JoinColumn(name = "AWB_ID", nullable = false)
	private AWB awb;

	@Column(name = "TOTAL_OTH_CHRG_CODE")
	private String totalOtherChargesCode;
	@Column(name = "TOTAL_OTH_CHRG_AMT")
	private Float totalOtherChargesAmount;
	@Column(name = "CHRG_ENTITLE_CODE_PRTY")
	private String chargeEntitledCodeParty;
	@Column(name = "OTH_CHRG_REASON_DESC")
	private String otherChargesReasonDescription;

	public OtherCharges() {
		super();
	}

	public OtherCharges(String totalOtherChargesCode,
			Float totalOtherChargesAmount, String chargeEntitledCodeParty,
			String otherChargesReasonDescription) {
		super();
		this.totalOtherChargesCode = totalOtherChargesCode;
		this.totalOtherChargesAmount = totalOtherChargesAmount;
		this.chargeEntitledCodeParty = chargeEntitledCodeParty;
		this.otherChargesReasonDescription = otherChargesReasonDescription;
	}

	/**
	 * @return the otherChargesId
	 */
	public Integer getOtherChargesId() {
		return otherChargesId;
	}

	/**
	 * @param otherChargesId
	 *            the handlingId to set
	 */
	public void setOtherChargesId(Integer otherChargesId) {
		this.otherChargesId = otherChargesId;
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
	 * @return the totalOtherChargesCode
	 */
	public String getTotalOtherChargesCode() {
		return totalOtherChargesCode;
	}

	/**
	 * @param totalOtherChargesCode
	 *            the totalOtherChargesCode to set
	 */
	public void setTotalOtherChargesCode(String totalOtherChargesCode) {
		this.totalOtherChargesCode = totalOtherChargesCode;
	}

	/**
	 * @return the totalOtherChargesAmount
	 */
	public Float getTotalOtherChargesAmount() {
		return totalOtherChargesAmount;
	}

	/**
	 * @param totalOtherChargesAmount
	 *            the totalOtherChargesAmount to set
	 */
	public void setTotalOtherChargesAmount(Float totalOtherChargesAmount) {
		this.totalOtherChargesAmount = totalOtherChargesAmount;
	}

	/**
	 * @return the chargeEntitledCodeParty
	 */
	public String getChargeEntitledCodeParty() {
		return chargeEntitledCodeParty;
	}

	/**
	 * @param chargeEntitledCodeParty
	 *            the chargeEntitledCodeParty to set
	 */
	public void setChargeEntitledCodeParty(String chargeEntitledCodeParty) {
		this.chargeEntitledCodeParty = chargeEntitledCodeParty;
	}

	/**
	 * @return the otherChargesReasonDescription
	 */
	public String getOtherChargesReasonDescription() {
		return otherChargesReasonDescription;
	}

	/**
	 * @param otherChargesReasonDescription
	 *            the otherChargesReasonDescription to set
	 */
	public void setOtherChargesReasonDescription(
			String otherChargesReasonDescription) {
		this.otherChargesReasonDescription = otherChargesReasonDescription;
	}
}
