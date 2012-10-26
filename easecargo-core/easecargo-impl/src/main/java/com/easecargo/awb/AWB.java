/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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
import javax.persistence.Table;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.*;

import com.easecargo.user.User;

 /* 
 * @author T2326
 */
@Entity
@Table(name = "AWB_MAIN")
public class AWB implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "AWB_ID")
	private Integer awbId;

	@OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.DETACH, CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
	@JoinColumn(name = "SHIPPER_ID", nullable = true)
	private Customer shipper;

	@OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.DETACH, CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
	@JoinColumn(name = "CONSIGNE_ID", nullable = true)
	private Customer consignee;

	@OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.DETACH, CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
	@JoinColumn(name = "AGENT_ID", nullable = true)
	private Customer agent;

	@OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.DETACH, CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
	@JoinColumn(name = "OTHPTY_ID", nullable = true)
	private Customer otherParty;

	@Column(name = "AWB_PRFIX")
	private Integer awbPrefix;
	@Column(name = "AWB_NUM")
	private Integer awbNumber;
	
	@Column(name = "TEMPLTE_IND")
	private String templateIndicator;

	@Column(name = "ORG_LOC_COD")
	private String originLocationCode;

	@Column(name = "ORG_LOC_NAME")
	private String originLocationName;
	@Column(name = "DES_LOC_COD")
	private String destinationLocationCode;
	@Column(name = "DES_LOC_NAME")
	private String destinationLocationName;
	@Column(name = "FLT_NUM")
	private String flightNumber;
	@Column(name = "FLT_DAT")
	private String flightDate;
	@Column(name = "REF_NUMBER")
	private String referenceNumber;
	@Column(name = "OPT_SHIP_INFO")
	private String optionalShipmentInfo;
	@Column(name = "ROUT_APT")
	private String routingAirport;
	@Column(name = "ROUT_COUNTY")
	private String routingCountry;
	@Column(name = "FIRST_CARR")
	private String firstCarrier;
	@Column(name = "TRANSIT_TO1")
	private String transitTo1;
	@Column(name = "TRANSIT_BY1")
	private String transitBy1;
	@Column(name = "TRANSIT_TO2")
	private String transitTo2;
	@Column(name = "TRANSIT_BY2")
	private String transitBy2;
	@Column(name = "DCL_VAL_CUSTMS")
	private String declaredValueCustoms;
	@Column(name = "DCL_VAL_CARRGE")
	private String declaredValueCarriage;
	@Column(name = "DCL_VAL_INSURNCE")
	private String decalredValueInsurance;
	@Column(name = "CHARG_COD")
	private String chanrgeCode;
	@Column(name = "TOTAL_LINES")
	private Integer totalLines;
	@Column(name = "TOTAL_PIECES")
	private Integer totalPieces;
	@Column(name = "TOTAL_GROS_WT")
	private Float totalGrossWeight;
	@Column(name = "TOTAL_GROS_WT_UNT")
	private String totalGrossWeightUnit;
	@Column(name = "TOTAL_SHP_GROS_CNT")
	private Integer totalShipmentGrossCount;
	@Column(name = "TOTAL_CHARG_AMT")
	private Float totalChargeAmount;
	@Column(name = "PPD_COLL_WV_IND")
	private String prepaidOrCollectWVIndicator;
	@Column(name = "WV_WEIGHT_CHARGE")
	private Float weightChargeWV;
	@Column(name = "WV_VAL_CHAR")
	private Float valueChargeWV;
	@Column(name = "WV_TAX")
	private Float taxWV;
	@Column(name = "PPD_COLL_OTH_CHG_IND")
	private String prepaidOrCollectOCIndicator;

	@Column(name = "TOTAL_OTH_CHARG_DUE_AGT")
	private Float totalchargeDueAgentOC;
	@Column(name = "TOTAL_OTH_CHARG_DUE_CARR")
	private Float totalChargeDureCarrierOC;
	@Column(name = "TOTAL_PREPAID")
	private Float totalPrepaid;
	@Column(name = "TOTAL_COLLECT")
	private Float totalCollect;
	@Column(name = "TOTAL_COLL_CHARGES")
	private Float totalCollectCharges;
	@Column(name = "SRC_CURR_COD")
	private String sourceCurrencyCode;
	@Column(name = "DEST_CURR_COD")
	private String destinationCurrencyCOde;
	@Column(name = "DEST_CURR_CONV_RAT")
	private Float destinationCurrencyConverionRate;
	@Column(name = "DEST_RAT_QLFYR")
	private Integer destinationRateQualifyer;
	@Column(name = "SVC_COD")
	private String serviceCode;
	@Column(name = "PRD_COD")
	private String prdCode;
	@Column(name = "CC_CHARG_DEST")
	private Float chargeCollectInDestinationCurrency;
	@Column(name = "CHARG_AMT_DEST")
	private Float chargeAmountDestination;

	@Column(name = "SCI")
	private String sci;

	@OneToMany(fetch = FetchType.EAGER, cascade =CascadeType.ALL,mappedBy = "awb")
	private Set<AccountInfo> accountInfos;
	@OneToMany(fetch = FetchType.EAGER,cascade =CascadeType.ALL, mappedBy = "awb")
	private Set<HandlingInfo> handlingInfos;
	@OneToMany(fetch = FetchType.EAGER ,cascade =CascadeType.ALL, mappedBy = "awb")
	private Set<OtherCharges> otherCarges;
	@OneToMany(fetch = FetchType.EAGER ,cascade =CascadeType.ALL, mappedBy = "awb")
	private Set<RateLine> rateLines;
	@OneToMany(fetch = FetchType.LAZY ,cascade =CascadeType.REMOVE, mappedBy = "awb")
	private Set<HAWB> hawbs;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID", nullable = false)
	private User user;
	
	public AWB() {
		super();
	}


	public Integer getAwbId() {
		return awbId;
	}


	public void setAwbId(Integer awbId) {
		this.awbId = awbId;
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


	public Customer getAgent() {
		return agent;
	}


	public void setAgent(Customer agent) {
		this.agent = agent;
	}


	public Customer getOtherParty() {
		return otherParty;
	}


	public void setOtherParty(Customer otherParty) {
		this.otherParty = otherParty;
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


	public String getTemplateIndicator() {
		return templateIndicator;
	}


	public void setTemplateIndicator(String templateIndicator) {
		this.templateIndicator = templateIndicator;
	}


	public String getOriginLocationCode() {
		return originLocationCode;
	}


	public void setOriginLocationCode(String originLocationCode) {
		this.originLocationCode = originLocationCode;
	}


	public String getOriginLocationName() {
		return originLocationName;
	}


	public void setOriginLocationName(String originLocationName) {
		this.originLocationName = originLocationName;
	}


	public String getDestinationLocationCode() {
		return destinationLocationCode;
	}


	public void setDestinationLocationCode(String destinationLocationCode) {
		this.destinationLocationCode = destinationLocationCode;
	}


	public String getDestinationLocationName() {
		return destinationLocationName;
	}


	public void setDestinationLocationName(String destinationLocationName) {
		this.destinationLocationName = destinationLocationName;
	}


	public String getFlightNumber() {
		return flightNumber;
	}


	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}


	public String getFlightDate() {
		return flightDate;
	}


	public void setFlightDate(String flightDate) {
		this.flightDate = flightDate;
	}


	public String getReferenceNumber() {
		return referenceNumber;
	}


	public void setReferenceNumber(String referenceNumber) {
		this.referenceNumber = referenceNumber;
	}


	public String getOptionalShipmentInfo() {
		return optionalShipmentInfo;
	}


	public void setOptionalShipmentInfo(String optionalShipmentInfo) {
		this.optionalShipmentInfo = optionalShipmentInfo;
	}


	public String getRoutingAirport() {
		return routingAirport;
	}


	public void setRoutingAirport(String routingAirport) {
		this.routingAirport = routingAirport;
	}


	public String getRoutingCountry() {
		return routingCountry;
	}


	public void setRoutingCountry(String routingCountry) {
		this.routingCountry = routingCountry;
	}


	public String getFirstCarrier() {
		return firstCarrier;
	}


	public void setFirstCarrier(String firstCarrier) {
		this.firstCarrier = firstCarrier;
	}


	public String getTransitTo1() {
		return transitTo1;
	}


	public void setTransitTo1(String transitTo1) {
		this.transitTo1 = transitTo1;
	}


	public String getTransitBy1() {
		return transitBy1;
	}


	public void setTransitBy1(String transitBy1) {
		this.transitBy1 = transitBy1;
	}


	public String getTransitTo2() {
		return transitTo2;
	}


	public void setTransitTo2(String transitTo2) {
		this.transitTo2 = transitTo2;
	}


	public String getTransitBy2() {
		return transitBy2;
	}


	public void setTransitBy2(String transitBy2) {
		this.transitBy2 = transitBy2;
	}


	public String getDeclaredValueCustoms() {
		return declaredValueCustoms;
	}


	public void setDeclaredValueCustoms(String declaredValueCustoms) {
		this.declaredValueCustoms = declaredValueCustoms;
	}


	public String getDeclaredValueCarriage() {
		return declaredValueCarriage;
	}


	public void setDeclaredValueCarriage(String declaredValueCarriage) {
		this.declaredValueCarriage = declaredValueCarriage;
	}


	public String getDecalredValueInsurance() {
		return decalredValueInsurance;
	}


	public void setDecalredValueInsurance(String decalredValueInsurance) {
		this.decalredValueInsurance = decalredValueInsurance;
	}


	public String getChanrgeCode() {
		return chanrgeCode;
	}


	public void setChanrgeCode(String chanrgeCode) {
		this.chanrgeCode = chanrgeCode;
	}


	public Integer getTotalLines() {
		return totalLines;
	}


	public void setTotalLines(Integer totalLines) {
		this.totalLines = totalLines;
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


	public Float getTotalChargeAmount() {
		return totalChargeAmount;
	}


	public void setTotalChargeAmount(Float totalChargeAmount) {
		this.totalChargeAmount = totalChargeAmount;
	}


	public String getPrepaidOrCollectWVIndicator() {
		return prepaidOrCollectWVIndicator;
	}


	public void setPrepaidOrCollectWVIndicator(String prepaidOrCollectWVIndicator) {
		this.prepaidOrCollectWVIndicator = prepaidOrCollectWVIndicator;
	}


	public Float getWeightChargeWV() {
		return weightChargeWV;
	}


	public void setWeightChargeWV(Float weightChargeWV) {
		this.weightChargeWV = weightChargeWV;
	}


	public Float getValueChargeWV() {
		return valueChargeWV;
	}


	public void setValueChargeWV(Float valueChargeWV) {
		this.valueChargeWV = valueChargeWV;
	}


	public Float getTaxWV() {
		return taxWV;
	}


	public void setTaxWV(Float taxWV) {
		this.taxWV = taxWV;
	}


	public String getPrepaidOrCollectOCIndicator() {
		return prepaidOrCollectOCIndicator;
	}


	public void setPrepaidOrCollectOCIndicator(String prepaidOrCollectOCIndicator) {
		this.prepaidOrCollectOCIndicator = prepaidOrCollectOCIndicator;
	}




	public Float getTotalchargeDueAgentOC() {
		return totalchargeDueAgentOC;
	}


	public void setTotalchargeDueAgentOC(Float totalchargeDueAgentOC) {
		this.totalchargeDueAgentOC = totalchargeDueAgentOC;
	}


	public Float getTotalChargeDureCarrierOC() {
		return totalChargeDureCarrierOC;
	}


	public void setTotalChargeDureCarrierOC(Float totalChargeDureCarrierOC) {
		this.totalChargeDureCarrierOC = totalChargeDureCarrierOC;
	}


	public Float getTotalPrepaid() {
		return totalPrepaid;
	}


	public void setTotalPrepaid(Float totalPrepaid) {
		this.totalPrepaid = totalPrepaid;
	}


	public Float getTotalCollect() {
		return totalCollect;
	}


	public void setTotalCollect(Float totalCollect) {
		this.totalCollect = totalCollect;
	}


	public Float getTotalCollectCharges() {
		return totalCollectCharges;
	}


	public void setTotalCollectCharges(Float totalCollectCharges) {
		this.totalCollectCharges = totalCollectCharges;
	}


	public String getSourceCurrencyCode() {
		return sourceCurrencyCode;
	}


	public void setSourceCurrencyCode(String sourceCurrencyCode) {
		this.sourceCurrencyCode = sourceCurrencyCode;
	}


	public String getDestinationCurrencyCOde() {
		return destinationCurrencyCOde;
	}


	public void setDestinationCurrencyCOde(String destinationCurrencyCOde) {
		this.destinationCurrencyCOde = destinationCurrencyCOde;
	}


	public Float getDestinationCurrencyConverionRate() {
		return destinationCurrencyConverionRate;
	}


	public void setDestinationCurrencyConverionRate(
			Float destinationCurrencyConverionRate) {
		this.destinationCurrencyConverionRate = destinationCurrencyConverionRate;
	}


	public Integer getDestinationRateQualifyer() {
		return destinationRateQualifyer;
	}


	public void setDestinationRateQualifyer(Integer destinationRateQualifyer) {
		this.destinationRateQualifyer = destinationRateQualifyer;
	}


	public String getServiceCode() {
		return serviceCode;
	}


	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}


	public String getPrdCode() {
		return prdCode;
	}


	public void setPrdCode(String prdCode) {
		this.prdCode = prdCode;
	}


	public Float getChargeCollectInDestinationCurrency() {
		return chargeCollectInDestinationCurrency;
	}


	public void setChargeCollectInDestinationCurrency(
			Float chargeCollectInDestinationCurrency) {
		this.chargeCollectInDestinationCurrency = chargeCollectInDestinationCurrency;
	}


	public Float getChargeAmountDestination() {
		return chargeAmountDestination;
	}


	public void setChargeAmountDestination(Float chargeAmountDestination) {
		this.chargeAmountDestination = chargeAmountDestination;
	}



	public String getSci() {
		return sci;
	}


	public void setSci(String sci) {
		this.sci = sci;
	}


	public Set<AccountInfo> getAccountInfos() {
		return accountInfos;
	}


	public void setAccountInfos(Set<AccountInfo> accountInfos) {
		this.accountInfos = accountInfos;
	}


	public Set<HandlingInfo> getHandlingInfos() {
		return handlingInfos;
	}


	public void setHandlingInfos(Set<HandlingInfo> handlingInfos) {
		this.handlingInfos = handlingInfos;
	}


	public Set<OtherCharges> getOtherCarges() {
		return otherCarges;
	}


	public void setOtherCarges(Set<OtherCharges> otherCarges) {
		this.otherCarges = otherCarges;
	}


	public Set<RateLine> getRateLines() {
		return rateLines;
	}


	public void setRateLines(Set<RateLine> rateLines) {
		this.rateLines = rateLines;
	}


	public Set<HAWB> getHawbs() {
		return hawbs;
	}


	public void setHawbs(Set<HAWB> hawbs) {
		this.hawbs = hawbs;
	}



	public User getUser() {
		return user;
	}




	public void setUser(User user) {
		this.user = user;
	}
	

}
