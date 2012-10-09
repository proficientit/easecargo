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
@Table(name = "DIM")
public class Dimension implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "DIM_ID")
	private Integer dimensionId;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "RAT_LIN_ID", nullable = false)
	private RateLine rateLine;

	@Column(name = "UNIT")
	private String unit;
	@Column(name = "LENGTH")
	private Float length;
	@Column(name = "WIDTH")
	private Float width;
	@Column(name = "HEIGHT")
	private Float height;
	@Column(name = "NO_OF_PEICES")
	private Integer noOfPieces;
	@Column(name = "WEIGHT_UNIT")
	private String weightUnit;
	@Column(name = "WEIGHT")
	private Float weight;

	public Dimension() {
		super();

	}

	public Integer getDimensionId() {
		return dimensionId;
	}

	public void setDimensionId(Integer dimensionId) {
		this.dimensionId = dimensionId;
	}

	public RateLine getRateLine() {
		return rateLine;
	}

	public void setRateLine(RateLine rateLine) {
		this.rateLine = rateLine;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
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

	public Integer getNoOfPieces() {
		return noOfPieces;
	}

	public void setNoOfPieces(Integer noOfPieces) {
		this.noOfPieces = noOfPieces;
	}

	public String getWeightUnit() {
		return weightUnit;
	}

	public void setWeightUnit(String weightUnit) {
		this.weightUnit = weightUnit;
	}

	public Float getWeight() {
		return weight;
	}

	public void setWeight(Float weight) {
		this.weight = weight;
	}
	
	
}
