package com.easecargo.general;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MST_COD")
public class CodesMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	public CodesMaster() {
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "MSTCOD_ID")
	private Integer codeId;
	
	@Column(name = "COD_TYP")
	private String codeType;
	@Column(name = "COD_VAL")
	private String codeValue;
	@Column(name = "COD_DESC")
	private String description;

	public Integer getCodeId() {
		return codeId;
	}
	public void setCodeId(Integer codeId) {
		this.codeId = codeId;
	}
	public String getCodeType() {
		return codeType;
	}
	public void setCodeType(String codeType) {
		this.codeType = codeType;
	}
	public String getCodeValue() {
		return codeValue;
	}
	public void setCodeValue(String codeValue) {
		this.codeValue = codeValue;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
