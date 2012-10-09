package com.easecargo.awb;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 
 * @author T2326
 */
@Entity
@Table(name = "RAT_LINE")
public class RateLine implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "RAT_LIN_ID")
	private Integer rateLineId;

	@ManyToOne(fetch = FetchType.EAGER,cascade =CascadeType.ALL)
	@JoinColumn(name = "AWB_ID", nullable = false)
	private AWB awb;

	@Column(name = "ITM_NUM")
	private Integer itemNumber;
	@Column(name = "ITM_DESC")
	private String itemDescritpion;
	@Column(name = "NO_PIECES")
	private Integer noOfPieces;
	@Column(name = "RCP")
	private String rcp;
	@Column(name = "GROS_WEIGHT")
	private Float grossWeight;
	@Column(name = "GROS_WEIGHT_UNIT")
	private String grossWeightUnit;
	@Column(name = "COMM_ITEM_NO")
	private String commodityItemNumber;
	@Column(name = "CHARG_WEIGHT")
	private Float chargedWeight;
	@Column(name = "RATE_CHARGE")
	private Float rateCharge;
	@Column(name = "TOTAL")
	private Float total;
	@Column(name = "SHIP_LOD_CNT")
	private Integer shipperLoadCount;
	@Column(name = "RAT_CLAS_COD")
	private String rateClassCode;
	@Column(name = "VOL_AMT")
	private Float volumeAmount;
	@Column(name = "CONV_FCTR")
	private String conversionFactor;
	@Column(name = "NAT_GOODS")
	private String natureOfGoods;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "rateLine")
	private Set<Dimension> dimensions;

	public RateLine() {
		super();
	}

	public Integer getRateLineId() {
		return rateLineId;
	}

	public void setRateLineId(Integer rateLineId) {
		this.rateLineId = rateLineId;
	}

	public AWB getAwb() {
		return awb;
	}

	public void setAwb(AWB awb) {
		this.awb = awb;
	}

	public Integer getItemNumber() {
		return itemNumber;
	}

	public void setItemNumber(Integer itemNumber) {
		this.itemNumber = itemNumber;
	}

	public String getItemDescritpion() {
		return itemDescritpion;
	}

	public void setItemDescritpion(String itemDescritpion) {
		this.itemDescritpion = itemDescritpion;
	}

	public Integer getNoOfPieces() {
		return noOfPieces;
	}

	public void setNoOfPieces(Integer noOfPieces) {
		this.noOfPieces = noOfPieces;
	}

	public String getRcp() {
		return rcp;
	}

	public void setRcp(String rcp) {
		this.rcp = rcp;
	}

	public Float getGrossWeight() {
		return grossWeight;
	}

	public void setGrossWeight(Float grossWeight) {
		this.grossWeight = grossWeight;
	}

	public String getGrossWeightUnit() {
		return grossWeightUnit;
	}

	public void setGrossWeightUnit(String grossWeightUnit) {
		this.grossWeightUnit = grossWeightUnit;
	}

	public String getCommodityItemNumber() {
		return commodityItemNumber;
	}

	public void setCommodityItemNumber(String commodityItemNumber) {
		this.commodityItemNumber = commodityItemNumber;
	}

	public Float getChargedWeight() {
		return chargedWeight;
	}

	public void setChargedWeight(Float chargedWeight) {
		this.chargedWeight = chargedWeight;
	}

	public Float getRateCharge() {
		return rateCharge;
	}

	public void setRateCharge(Float rateCharge) {
		this.rateCharge = rateCharge;
	}

	public Float getTotal() {
		return total;
	}

	public void setTotal(Float total) {
		this.total = total;
	}

	public Integer getShipperLoadCount() {
		return shipperLoadCount;
	}

	public void setShipperLoadCount(Integer shipperLoadCount) {
		this.shipperLoadCount = shipperLoadCount;
	}

	public String getRateClassCode() {
		return rateClassCode;
	}

	public void setRateClassCode(String rateClassCode) {
		this.rateClassCode = rateClassCode;
	}

	public Float getVolumeAmount() {
		return volumeAmount;
	}

	public void setVolumeAmount(Float volumeAmount) {
		this.volumeAmount = volumeAmount;
	}

	public String getConversionFactor() {
		return conversionFactor;
	}

	public void setConversionFactor(String conversionFactor) {
		this.conversionFactor = conversionFactor;
	}

	public String getNatureOfGoods() {
		return natureOfGoods;
	}

	public void setNatureOfGoods(String natureOfGoods) {
		this.natureOfGoods = natureOfGoods;
	}

	public Set<Dimension> getDimensions() {
		return dimensions;
	}

	public void setDimensions(Set<Dimension> dimensions) {
		this.dimensions = dimensions;
	}

}
