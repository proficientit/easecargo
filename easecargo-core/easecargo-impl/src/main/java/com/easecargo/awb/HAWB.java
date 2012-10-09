/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.easecargo.awb;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.easecargo.user.User;

 /* 
 * @author T2326
 */
@Entity
@Table(name = "HAWB_MAIN")
public class HAWB implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "HAWB_ID")	
	Integer hawbId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "AWB_ID", nullable = false)
	AWB awb;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.DETACH, CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
	@JoinColumn(name = "SHIPPER_ID", nullable = true)
	private Customer shipper;

	@OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.DETACH, CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
	@JoinColumn(name = "CONSIGNE_ID", nullable = true)
	private Customer consignee;
	
	@Column(name="TEMP_NAME")
	private String temporaryName;
	@Column(name="HAWB_NUM")
	private String hawbNum;
	@Column(name="PIECES")
	private Integer pieces;
	@Column(name="WEIGHT")
	private Float weight;
	@Column(name="VOLUME")
	private Float volume;
	@Column(name="VOL_UNT")
	private String volumeUnit;
	@Column(name="LENGTH")
	private Float length;
	@Column(name="WIDTH")
	private Float width;
	@Column(name="HEIGHT")
	private Float height;
	@Column(name="DIM_UNT")
	private String dimensionUnit;
	@Column(name="NAT_GOODs")
	private String natureOfGoods;
	@Column(name="HARMNZED_COD")
	private String harmonizedCode;
	@Column(name="OCI_INFO")
	private String ociInfo;
	@Column(name="CURR")
	private String currency;
	@Column(name="CHRG")
	private String charge;
	@Column(name="DCL_VAL_CARR")
	private Float declaredValueCarrier;
	@Column(name="DCL_VAL_CUST")
	private Float declaredValueCustomer;
	@Column(name="INSUR_AMT")
	private Float insuredAmount;
	@Column(name="CNT_PERSON")
	private String contactPerson;
	@Column(name="CNT_PHON")
	private String contactPhone;
	@Column(name="RMKS")
	private String remarks;
	@Column(name="DEPT_APT_NAME")
	private String departureAirportName;
	@Column(name="DEPT_APT_CODE")
	private String departureAirportCode;
	@Column(name="DEST_APT_NAME")
	private String destinationAriportName;
	@Column(name="DEST_APT_CODE")
	private String destinationAirportCode;
	@Column(name="FLT_NUMBER")
	private String flightNumber;
	@Column(name="FLT_DATE")
	private Timestamp flightDate;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID", nullable = false)
	private User user;
	
	private transient Integer awbPrefix;
	private transient Integer awbNumber;
	private transient Integer totalPieces;
	private transient Float totalGrossWeight;
	private transient String totalGrossWeightUnit;
	private transient Integer totalShipmentGrossCount;
	
	
	
	
	public HAWB() {
		super();
	}




	public Integer getHawbId() {
		return hawbId;
	}




	public void setHawbId(Integer hawbId) {
		this.hawbId = hawbId;
	}




	public AWB getAwb() {
		return awb;
	}




	public void setAwb(AWB awb) {
		this.awb = awb;
	}




	public Customer getShipper() {
		return shipper;
	}




	public void setShipper(Customer shipper) {
		this.shipper = shipper;
	}




	public Customer getConsignee() {
		return consignee;
	}




	public void setConsignee(Customer consignee) {
		this.consignee = consignee;
	}




	public String getTemporaryName() {
		return temporaryName;
	}




	public void setTemporaryName(String temporaryName) {
		this.temporaryName = temporaryName;
	}




	public String getHawbNum() {
		return hawbNum;
	}




	public void setHawbNum(String hawbNum) {
		this.hawbNum = hawbNum;
	}




	public Integer getPieces() {
		return pieces;
	}




	public void setPieces(Integer pieces) {
		this.pieces = pieces;
	}




	public Float getWeight() {
		return weight;
	}




	public void setWeight(Float weight) {
		this.weight = weight;
	}




	public Float getVolume() {
		return volume;
	}




	public void setVolume(Float volume) {
		this.volume = volume;
	}




	public String getVolumeUnit() {
		return volumeUnit;
	}




	public void setVolumeUnit(String volumeUnit) {
		this.volumeUnit = volumeUnit;
	}




	public Float getLength() {
		return length;
	}




	public void setLength(Float length) {
		this.length = length;
	}




	public Float getWidth() {
		return width;
	}




	public void setWidth(Float width) {
		this.width = width;
	}




	public Float getHeight() {
		return height;
	}




	public void setHeight(Float height) {
		this.height = height;
	}




	public String getDimensionUnit() {
		return dimensionUnit;
	}




	public void setDimensionUnit(String dimensionUnit) {
		this.dimensionUnit = dimensionUnit;
	}




	public String getNatureOfGoods() {
		return natureOfGoods;
	}




	public void setNatureOfGoods(String natureOfGoods) {
		this.natureOfGoods = natureOfGoods;
	}




	public String getHarmonizedCode() {
		return harmonizedCode;
	}




	public void setHarmonizedCode(String harmonizedCode) {
		this.harmonizedCode = harmonizedCode;
	}




	public String getOciInfo() {
		return ociInfo;
	}




	public void setOciInfo(String ociInfo) {
		this.ociInfo = ociInfo;
	}




	public String getCurrency() {
		return currency;
	}




	public void setCurrency(String currency) {
		this.currency = currency;
	}




	public String getCharge() {
		return charge;
	}




	public void setCharge(String charge) {
		this.charge = charge;
	}




	public Float getDeclaredValueCarrier() {
		return declaredValueCarrier;
	}




	public void setDeclaredValueCarrier(Float declaredValueCarrier) {
		this.declaredValueCarrier = declaredValueCarrier;
	}




	public Float getDeclaredValueCustomer() {
		return declaredValueCustomer;
	}




	public void setDeclaredValueCustomer(Float declaredValueCustomer) {
		this.declaredValueCustomer = declaredValueCustomer;
	}




	public Float getInsuredAmount() {
		return insuredAmount;
	}




	public void setInsuredAmount(Float insuredAmount) {
		this.insuredAmount = insuredAmount;
	}




	public String getContactPerson() {
		return contactPerson;
	}




	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}




	public String getContactPhone() {
		return contactPhone;
	}




	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}




	public String getRemarks() {
		return remarks;
	}




	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}




	public String getDepartureAirportName() {
		return departureAirportName;
	}




	public void setDepartureAirportName(String departureAirportName) {
		this.departureAirportName = departureAirportName;
	}




	public String getDepartureAirportCode() {
		return departureAirportCode;
	}




	public void setDepartureAirportCode(String departureAirportCode) {
		this.departureAirportCode = departureAirportCode;
	}




	public String getDestinationAriportName() {
		return destinationAriportName;
	}




	public void setDestinationAriportName(String destinationAriportName) {
		this.destinationAriportName = destinationAriportName;
	}




	public String getDestinationAirportCode() {
		return destinationAirportCode;
	}




	public void setDestinationAirportCode(String destinationAirportCode) {
		this.destinationAirportCode = destinationAirportCode;
	}




	public String getFlightNumber() {
		return flightNumber;
	}




	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}




	public Timestamp getFlightDate() {
		return flightDate;
	}




	public void setFlightDate(Timestamp flightDate) {
		this.flightDate = flightDate;
	}




	public Integer getAwbPrefix() {
		return awbPrefix;
	}




	public void setAwbPrefix(Integer awbPrefix) {
		this.awbPrefix = awbPrefix;
	}




	public Integer getAwbNumber() {
		return awbNumber;
	}




	public void setAwbNumber(Integer awbNumber) {
		this.awbNumber = awbNumber;
	}




	public Integer getTotalPieces() {
		return totalPieces;
	}




	public void setTotalPieces(Integer totalPieces) {
		this.totalPieces = totalPieces;
	}




	public Float getTotalGrossWeight() {
		return totalGrossWeight;
	}




	public void setTotalGrossWeight(Float totalGrossWeight) {
		this.totalGrossWeight = totalGrossWeight;
	}




	public String getTotalGrossWeightUnit() {
		return totalGrossWeightUnit;
	}




	public void setTotalGrossWeightUnit(String totalGrossWeightUnit) {
		this.totalGrossWeightUnit = totalGrossWeightUnit;
	}




	public Integer getTotalShipmentGrossCount() {
		return totalShipmentGrossCount;
	}




	public void setTotalShipmentGrossCount(Integer totalShipmentGrossCount) {
		this.totalShipmentGrossCount = totalShipmentGrossCount;
	}




	public User getUser() {
		return user;
	}




	public void setUser(User user) {
		this.user = user;
	}
	
	
}