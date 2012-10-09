package com.easecargo.awb;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.easecargo.user.User;

public class AirwayBill  extends AWB {
	
	private List<AccountInfo> accountInfoList;
	private List<HandlingInfo> handlingInfoList;
	private List<OtherCharges> otherChargesList;
	private List<RateLineForm> rateLinesList;
	
	private String shc1;
	private String shc2;
	private String shc3;
	private String shc4;
	private String shc5;
	private String shc6;
	private String shc7;
	private String shc8;              
	private String shc9;  
	
	public String getAWBString(){
		if(getAwbPrefix() != null && getAwbNumber() !=null){
			return getAwbPrefix() + " - " + getAwbNumber();
		}
		return "";                 
	}
	
	public String getShc1() {
		return shc1;
	}        


	public void setShc1(String shc1) {
		this.shc1 = shc1;
	}

   
	public String getShc2() {
		return shc2;
	}


	public void setShc2(String shc2) {
		this.shc2 = shc2;
	}


	public String getShc3() {
		return shc3;
	}


	public void setShc3(String shc3) {
		this.shc3 = shc3;
	}


	public String getShc4() {
		return shc4;
	}


	public void setShc4(String shc4) {
		this.shc4 = shc4;
	}


	public String getShc5() {
		return shc5;
	}


	public void setShc5(String shc5) {
		this.shc5 = shc5;
	}


	public String getShc6() {
		return shc6;
	}


	public void setShc6(String shc6) {
		this.shc6 = shc6;
	}


	public String getShc7() {
		return shc7;
	}


	public void setShc7(String shc7) {
		this.shc7 = shc7;
	}


	public String getShc8() {
		return shc8;
	}


	public void setShc8(String shc8) {
		this.shc8 = shc8;
	}


	public String getShc9() {
		return shc9;
	}


	public void setShc9(String shc9) {
		this.shc9 = shc9;
	}


	
	public List<AccountInfo> getAccountInfoList() {
		return accountInfoList;
	}


	public void setAccountInfoList(List<AccountInfo> accountInfoList) {
		this.accountInfoList = accountInfoList;
	}


	public List<HandlingInfo> getHandlingInfoList() {
		return handlingInfoList;
	}


	public void setHandlingInfoList(List<HandlingInfo> handlingInfoList) {
		this.handlingInfoList = handlingInfoList;
	}


	public List<OtherCharges> getOtherCargesList() {
		return otherChargesList;
	}


	public void setOtherCargesList(List<OtherCharges> otherChargesList) {
		this.otherChargesList = otherChargesList;
	}


	public List<RateLineForm> getRateLinesList() {
		return rateLinesList;
	}


	public void setRateLinesList(List<RateLineForm> rateLinesList) {
		this.rateLinesList =rateLinesList;
	}
 
    
	public AWB toModel(){
		
		AWB awb = new AWB();
		
		awb.setAccountInfos(accountList2Set(slimAccountList(getAccountInfoList(),awb)));

		awb.setAgent(getAgent());
		awb.setAwbId(getAwbId());
		awb.setAwbNumber(getAwbNumber());
		awb.setAwbPrefix(getAwbPrefix());
		awb.setChanrgeCode(getChanrgeCode());
		awb.setChargeAmountDestination(getChargeAmountDestination());
		awb.setChargeCollectInDestinationCurrency(getChargeCollectInDestinationCurrency());
		awb.setConsignee(getConsignee());
		awb.setDecalredValueInsurance(getDecalredValueInsurance());
		awb.setDeclaredValueCarriage(getDeclaredValueCarriage());
		awb.setDeclaredValueCustoms(getDeclaredValueCustoms());
		awb.setDestinationCurrencyCOde(getDestinationCurrencyCOde());
		awb.setDestinationCurrencyConverionRate(getDestinationCurrencyConverionRate());
		awb.setDestinationLocationCode(getDestinationLocationCode());
		awb.setDestinationLocationName(getDestinationLocationName());
		awb.setDestinationRateQualifyer(getDestinationRateQualifyer());
		awb.setFirstCarrier(getFirstCarrier());
		awb.setFlightDate(getFlightDate());
		awb.setFlightNumber(getFlightNumber());
		
		awb.setHandlingInfos(handlingList2Set(slimHandlingList(getHandlingInfoList(),awb)));
		
	//	awb.setHawbs(getHawbs());
	//	for(HAWB hawb  : getHawbs()){
	//		hawb.setAwb(awb);
	//	}
		
		awb.setOptionalShipmentInfo(getOptionalShipmentInfo());
		awb.setOriginLocationCode(getOriginLocationCode());
		awb.setOriginLocationName(getOriginLocationName());
		
		awb.setOtherCarges(ocList2Set(slimOtherChargesList(getOtherCargesList(),awb)));
		
		awb.setOtherParty(getOtherParty());
		awb.setPrdCode(getPrdCode());
		awb.setPrepaidOrCollectOCIndicator(getPrepaidOrCollectOCIndicator());
		awb.setPrepaidOrCollectWVIndicator(getPrepaidOrCollectWVIndicator());
		
		awb.setRateLines(RateLineForm.rateLineList2Set(RateLineForm.toModels(RateLineForm.slimRateLineList(getRateLinesList(),awb))));
		
		awb.setReferenceNumber(getReferenceNumber());
		awb.setRoutingAirport(getRoutingAirport());
		awb.setRoutingCountry(getRoutingCountry());
		awb.setSci(getSci());
		awb.setServiceCode(getServiceCode());
		awb.setShipper(getShipper());
		awb.setSourceCurrencyCode(getSourceCurrencyCode());
		awb.setTaxWV(getTaxWV());
		awb.setTemplateIndicator(getTemplateIndicator());
		awb.setTotalChargeAmount(getTotalChargeAmount());
		awb.setTotalchargeDueAgentOC(getTotalchargeDueAgentOC());
		awb.setTotalChargeDureCarrierOC(getTotalChargeDureCarrierOC());
		awb.setTotalCollect(getTotalCollect());
		awb.setTotalCollectCharges(getTotalCollectCharges());
		awb.setTotalGrossWeight(getTotalGrossWeight());
		awb.setTotalGrossWeightUnit(getTotalGrossWeightUnit());
		awb.setTotalLines(getTotalLines());
		awb.setTotalPieces(getTotalPieces());
		awb.setTotalPrepaid(getTotalPrepaid());
		awb.setTotalShipmentGrossCount(getTotalShipmentGrossCount());
		awb.setTransitBy1(getTransitBy1());
		awb.setTransitBy2(getTransitBy2());
		awb.setTransitTo1(getTransitTo1());
		awb.setTransitTo2(getTransitTo2());
		awb.setUser(getUser());
		awb.setValueChargeWV(getValueChargeWV());
		awb.setWeightChargeWV(getWeightChargeWV());
		
		setSHCtoModel(awb);
		
		return awb;
	}
		
	public static AirwayBill toForm(AWB awb){		
		AirwayBill airwayBill = new AirwayBill();		
		
		airwayBill.setUser(awb.getUser());
		
		airwayBill.setAccountInfoList(paddAccountList(accountSet2List(awb.getAccountInfos())));
		
		airwayBill.setAgent(awb.getAgent());
		airwayBill.setAwbId(awb.getAwbId());
		airwayBill.setAwbNumber(awb.getAwbNumber());
		airwayBill.setAwbPrefix(awb.getAwbPrefix());
		airwayBill.setChanrgeCode(awb.getChanrgeCode());
		airwayBill.setChargeAmountDestination(awb.getChargeAmountDestination());
		airwayBill.setChargeCollectInDestinationCurrency(awb.getChargeCollectInDestinationCurrency());
		airwayBill.setConsignee(awb.getConsignee());
		airwayBill.setDecalredValueInsurance(awb.getDecalredValueInsurance());
		airwayBill.setDeclaredValueCarriage(awb.getDeclaredValueCarriage());
		airwayBill.setDeclaredValueCustoms(awb.getDeclaredValueCustoms());
		airwayBill.setDestinationCurrencyCOde(awb.getDestinationCurrencyCOde());
		airwayBill.setDestinationCurrencyConverionRate(awb.getDestinationCurrencyConverionRate());
		airwayBill.setDestinationLocationCode(awb.getDestinationLocationCode());
		airwayBill.setDestinationLocationName(awb.getDestinationLocationName());
		airwayBill.setDestinationRateQualifyer(awb.getDestinationRateQualifyer());
		airwayBill.setFirstCarrier(awb.getFirstCarrier());
		airwayBill.setFlightDate(awb.getFlightDate());
		airwayBill.setFlightNumber(awb.getFlightNumber());
		
		airwayBill.setHandlingInfoList(paddHandlingList(handlingSet2List(awb.getHandlingInfos())));
		
		airwayBill.setOptionalShipmentInfo(awb.getOptionalShipmentInfo());
		airwayBill.setOriginLocationCode(awb.getOriginLocationCode());
		airwayBill.setOriginLocationName(awb.getOriginLocationName());
		
		airwayBill.setOtherCargesList(paddOtherChargesList(ocSet2List(awb.getOtherCarges())));
		
		airwayBill.setOtherParty(awb.getOtherParty());
		airwayBill.setPrdCode(awb.getPrdCode());
		airwayBill.setPrepaidOrCollectOCIndicator(awb.getPrepaidOrCollectOCIndicator());
		airwayBill.setPrepaidOrCollectWVIndicator(awb.getPrepaidOrCollectWVIndicator());
		
		airwayBill.setRateLinesList(RateLineForm.paddRateLineList(RateLineForm.toForms(RateLineForm.rateLineSet2List(awb.getRateLines()))));
		
		airwayBill.setReferenceNumber(awb.getReferenceNumber());
		airwayBill.setRoutingAirport(awb.getRoutingAirport());
		airwayBill.setRoutingCountry(awb.getRoutingCountry());
		airwayBill.setSci(awb.getSci());
		airwayBill.setServiceCode(awb.getServiceCode());
		airwayBill.setShipper(awb.getShipper());
		airwayBill.setSourceCurrencyCode(awb.getSourceCurrencyCode());
		airwayBill.setTaxWV(awb.getTaxWV());
		airwayBill.setTemplateIndicator(awb.getTemplateIndicator());
		airwayBill.setTotalChargeAmount(awb.getTotalChargeAmount());
		airwayBill.setTotalchargeDueAgentOC(awb.getTotalchargeDueAgentOC());
		airwayBill.setTotalChargeDureCarrierOC(awb.getTotalChargeDureCarrierOC());
		airwayBill.setTotalCollect(awb.getTotalCollect());
		airwayBill.setTotalCollectCharges(awb.getTotalCollectCharges());
		airwayBill.setTotalGrossWeight(awb.getTotalGrossWeight());
		airwayBill.setTotalGrossWeightUnit(awb.getTotalGrossWeightUnit());
		airwayBill.setTotalLines(awb.getTotalLines());
		airwayBill.setTotalPieces(awb.getTotalPieces());
		airwayBill.setTotalPrepaid(awb.getTotalPrepaid());
		airwayBill.setTotalShipmentGrossCount(awb.getTotalShipmentGrossCount());
		airwayBill.setTransitBy1(awb.getTransitBy1());
		airwayBill.setTransitBy2(awb.getTransitBy2());
		airwayBill.setTransitTo1(awb.getTransitTo1());
		airwayBill.setTransitTo2(awb.getTransitTo2());
		airwayBill.setUser(awb.getUser());
		airwayBill.setValueChargeWV(awb.getValueChargeWV());
		airwayBill.setWeightChargeWV(awb.getWeightChargeWV());		
		
		setSHCstoForm(airwayBill);
		
		return airwayBill;
	}
	
	/** when creating Model, update SHC list from flattern structure to List **/
	private void setSHCtoModel(AWB awb){ 	
		if(shc1 != null || shc1.isEmpty()){
			HandlingInfo handlingInfo = new HandlingInfo();
			handlingInfo.setServiceTypeCode(shc1);
			handlingInfo.setHandlignCategory("SHC");
			handlingInfo.setAwb(awb);
			getHandlingInfos().add(handlingInfo);
		}
		if(shc2 != null || shc2.isEmpty()){
			HandlingInfo handlingInfo = new HandlingInfo();
			handlingInfo.setServiceTypeCode(shc2);
			handlingInfo.setHandlignCategory("SHC");
			handlingInfo.setAwb(awb);
			getHandlingInfos().add(handlingInfo);
		}

		if(shc3 != null || shc3.isEmpty()){
			HandlingInfo handlingInfo = new HandlingInfo();
			handlingInfo.setServiceTypeCode(shc3);
			handlingInfo.setHandlignCategory("SHC");
			handlingInfo.setAwb(awb);
			getHandlingInfos().add(handlingInfo);
		}		
		if(shc4 != null || shc4.isEmpty()){
			HandlingInfo handlingInfo = new HandlingInfo();
			handlingInfo.setServiceTypeCode(shc4);
			handlingInfo.setHandlignCategory("SHC");
			handlingInfo.setAwb(awb);
			getHandlingInfos().add(handlingInfo);
		}
		if(shc5 != null || shc5.isEmpty()){
			HandlingInfo handlingInfo = new HandlingInfo();
			handlingInfo.setServiceTypeCode(shc5);
			handlingInfo.setAwb(awb);
			handlingInfo.setHandlignCategory("SHC");
			getHandlingInfos().add(handlingInfo);
		}			
		if(shc6 != null || shc6.isEmpty()){
			HandlingInfo handlingInfo = new HandlingInfo();
			handlingInfo.setServiceTypeCode(shc6);
			handlingInfo.setHandlignCategory("SHC");
			handlingInfo.setAwb(awb);
			getHandlingInfos().add(handlingInfo);
		}

		if(shc7 != null || shc7.isEmpty()){
			HandlingInfo handlingInfo = new HandlingInfo();
			handlingInfo.setServiceTypeCode(shc7);
			handlingInfo.setHandlignCategory("SHC");
			handlingInfo.setAwb(awb);
			getHandlingInfos().add(handlingInfo);
		}		
		if(shc8 != null || shc8.isEmpty()){
			HandlingInfo handlingInfo = new HandlingInfo();
			handlingInfo.setServiceTypeCode(shc8);
			handlingInfo.setHandlignCategory("SHC");
			handlingInfo.setAwb(awb);
			getHandlingInfos().add(handlingInfo);
		}
		if(shc9 != null || shc9.isEmpty()){
			HandlingInfo handlingInfo = new HandlingInfo();
			handlingInfo.setServiceTypeCode(shc9);
			handlingInfo.setHandlignCategory("SHC");
			handlingInfo.setAwb(awb);
			getHandlingInfos().add(handlingInfo);
		}		
	}	
	
	/** when creating FORM, flattern SHCs from Model handling Information **/
    public static void setSHCstoForm(AirwayBill awb){
		Iterator<HandlingInfo> iter =  awb.getHandlingInfoList().iterator();
		int i=1;
		while(iter.hasNext()){
			HandlingInfo handlingInfo = iter.next();
			if(handlingInfo.getHandlignCategory() != null && handlingInfo.getHandlignCategory().equals("SHC")){				
				if(i == 1){ 
					awb.setShc1(handlingInfo.getServiceTypeCode());
				}
				if(i == 2){ 
					awb.setShc2(handlingInfo.getServiceTypeCode());
				}
				if(i == 3){ 
					awb.setShc3(handlingInfo.getServiceTypeCode());
				}
				if(i == 4){ 
					awb.setShc4(handlingInfo.getServiceTypeCode());
				}
				if(i == 5){ 
					awb.setShc5(handlingInfo.getServiceTypeCode());
				}				
				if(i == 6){ 
					awb.setShc6(handlingInfo.getServiceTypeCode());
				}
				if(i == 7){ 
					awb.setShc7(handlingInfo.getServiceTypeCode());
				}
				if(i == 8){ 
					awb.setShc8(handlingInfo.getServiceTypeCode());
				}
				if(i == 9){ 
					awb.setShc9(handlingInfo.getServiceTypeCode());
				}
				iter.remove();
			}
			i++;	
		}		
    }  
    
 
	//account info padded up to 5
	private static List<AccountInfo> paddAccountList(List<AccountInfo> list){    
		for(int i=list.size(); i < 5 ; i++){
			AccountInfo act = new AccountInfo();
			list.add(act);
		}
		return list;
	}

	public static List<AccountInfo> slimAccountList(List<AccountInfo> list, AWB awb){
		Iterator<AccountInfo> iter = list.iterator();
		while(iter.hasNext()){
			AccountInfo account = iter.next();			
			if(account.getAccountIdentity() == null || account.getAccountIdentity().isEmpty() ){				
				iter.remove();   
			} else {
				account.setAwb(awb);
			}
		}
		return list;
	}	

	public static List<HandlingInfo> paddHandlingList(List<HandlingInfo> list){
		for(int i= list.size(); i < 3 ; i++){
			HandlingInfo hnd = new HandlingInfo();
			list.add(hnd);		
		}
		return list;
	}

	public static List<HandlingInfo> slimHandlingList(List<HandlingInfo> list, AWB awb){
		Iterator<HandlingInfo> iter1 = list.iterator();
		while(iter1.hasNext()){
			HandlingInfo handlingInfo = iter1.next();
			if(handlingInfo.getServiceTypeCode() == null || handlingInfo.getServiceTypeCode().isEmpty()){
				iter1.remove();
			} else {
				handlingInfo.setAwb(awb);
			}
		}
		return list;
	}	
	
	public static List<OtherCharges> paddOtherChargesList(List<OtherCharges> list){
		for(int i=list.size(); i < 3 ; i++){
			OtherCharges oc = new OtherCharges();
			list.add(oc);
		}  
		return list;
	}

	public static List<OtherCharges> slimOtherChargesList(List<OtherCharges> list, AWB awb){
		Iterator<OtherCharges> iter2 = list.iterator();
		while(iter2.hasNext()){
			OtherCharges otherCharges = iter2.next();
			if(otherCharges.getTotalOtherChargesCode() == null || otherCharges.getTotalOtherChargesCode().isEmpty()){
				iter2.remove();
			} else {
				otherCharges.setAwb(awb);
			}
		}
		return list;
	}		
	
	private static List<AccountInfo> accountSet2List(Set<AccountInfo> set){
		List<AccountInfo> list = new ArrayList<AccountInfo>();
		if(set != null){ 
			list.addAll(set);
		}
		return list;
	}
	
	private static Set<AccountInfo> accountList2Set(List<AccountInfo> list){
		Set<AccountInfo> set = new HashSet<AccountInfo>();
		set.addAll(list);
		return set;
	}

	private static List<OtherCharges> ocSet2List(Set<OtherCharges> set){
		List<OtherCharges> list = new ArrayList<OtherCharges>();
		if(set != null){ 
			list.addAll(set);
		}
		return list;
	}
	
	private static Set<OtherCharges> ocList2Set(List<OtherCharges> list){
		Set<OtherCharges> set = new HashSet<OtherCharges>();
		set.addAll(list);
		return set;
	}
	
	private static List<HandlingInfo> handlingSet2List(Set<HandlingInfo> set){
		List<HandlingInfo> list = new ArrayList<HandlingInfo>();
		if(set != null){ 
			list.addAll(set);
		}
		return list;
	}
	
	private static Set<HandlingInfo> handlingList2Set(List<HandlingInfo> list){
		Set<HandlingInfo> set = new HashSet<HandlingInfo>();
		set.addAll(list);
		return set;
	}  
	
    public static AirwayBill buildPrefilledAWB(User u){ 
        
    	AirwayBill awb = new AirwayBill();
		awb.setAwbPrefix(157);
		awb.setAwbNumber(12345675);
		awb.setUser(u);	
		
		Customer shipper = new Customer();
		shipper.setUser(u);
		shipper.setCustomerName("Fashion");
		shipper.setAddress("#10,Nile St. Airport Road");
		shipper.setCityName("Madrid");
		shipper.setContactName("Gradia");
		shipper.setCountryName("Spain");
		shipper.setEmail("info@fashion.com");
		shipper.setPhoneNumber(82389329); 
		shipper.setPoBox(1232);
		shipper.setAccountNumber("233332322");
 
		Customer consignee = new Customer();
		consignee.setUser(u);
		consignee.setCustomerName("Wild Mart");
		consignee.setAddress("#10,Elstra St. Mount Road");
		consignee.setCityName("Toronto");
		consignee.setContactName("Silvester");
		consignee.setCountryName("Canada");
		consignee.setEmail("info@wildmart.com");
		consignee.setPhoneNumber(82879329); 
		consignee.setPoBox(1222);
		consignee.setAccountNumber("88886644");
 
		Customer airline = new Customer();
		airline.setUser(u);
		airline.setCustomerName("British Airways");
		airline.setAddress("Waterside");
		airline.setCityName("London");
		airline.setContactName("Michel");
		airline.setCountryName("United Kingdom");
		airline.setEmail("info@wbaworldcargo.com");
		airline.setPhoneNumber(44479329); 
		airline.setPoBox(365);
		
		
		
		Customer agent = new Customer();
		agent.setUser(u);
		agent.setCustomerName("Logistics");
		agent.setAddress("La Coruna");
		agent.setCityName("Madrid");
		agent.setContactName("Lewis");
		agent.setCountryName("Spain");
		agent.setEmail("info@logisticscargo.com");
		agent.setPhoneNumber(11179329); 
		agent.setPoBox(1116);	
		agent.setAgentIATACode(1223);
		agent.setAgentIATACASSCode(6433);
		
		awb.setAgent(agent);
		awb.setConsignee(consignee);
		awb.setOtherParty(airline);
	 	awb.setShipper(shipper);
		
		AccountInfo act = new AccountInfo();
		act.setAccountIdentity("10");
		act.setAwb(awb);
		List<AccountInfo> accountInfos = new java.util.ArrayList<AccountInfo>();
		accountInfos.add(act);
		
		HandlingInfo hnd = new HandlingInfo();
		hnd.setServiceTypeCode("SSR");
		hnd.setAwb(awb);
		List<HandlingInfo> handlingInfos = new java.util.ArrayList<HandlingInfo>();
		handlingInfos.add(hnd);		
	
		OtherCharges oc = new OtherCharges();
		oc.setTotalOtherChargesCode("C");
		oc.setAwb(awb);
		List<OtherCharges> oCharges = new java.util.ArrayList<OtherCharges>();
		oCharges.add(oc);		
	
		RateLineForm rl = new RateLineForm();
		rl.setChargedWeight(99.9f);
		rl.setGrossWeight(100.1f);   
		rl.setGrossWeightUnit("Kg");
		rl.setNatureOfGoods("Cloths");
		rl.setNoOfPieces(1);
		rl.setRateCharge(100.2f);
		rl.setRateClassCode("C");
		rl.setAwb(awb);
		
		Dimension dim = new Dimension();
		dim.setHeight(33.0f);
		dim.setWidth(44.0f);
		dim.setRateLine(rl);
		List<Dimension> dims = new java.util.ArrayList<Dimension>();
		dims.add(dim);

		Dimension dim1 = new Dimension();
		dim1.setHeight(23.0f);
		dim1.setWidth(24.0f);
		dim1.setRateLine(rl);		               
		dims.add(dim1);
		
		rl.setDims(RateLineForm.paddDimList(dims));
		
		List<RateLineForm> rateLines = new java.util.ArrayList<RateLineForm>();
		rateLines.add(rl);				
		
		awb.setHandlingInfoList(paddHandlingList(handlingInfos));
		awb.setAccountInfoList(paddAccountList(accountInfos));
		awb.setOtherCargesList(paddOtherChargesList(oCharges));  
		awb.setRateLinesList(RateLineForm.paddRateLineList(rateLines));
		
		awb.setChanrgeCode("C");
		
		
		awb.setFlightNumber("BA0001");             
		awb.setOriginLocationName("MAD");
		awb.setRoutingAirport("LHR");
		awb.setDestinationLocationName("MON");
		awb.setFlightDate(new Timestamp(new Date().getTime()));
		awb.setFirstCarrier("BA");
		
		awb.setSourceCurrencyCode("EUR");
		awb.setDecalredValueInsurance("1500");
		awb.setDeclaredValueCarriage("1200");
		awb.setDeclaredValueCustoms("1300");
		
		awb.setTaxWV(10.0f);
		awb.setValueChargeWV(14.0f);
		awb.setWeightChargeWV(800.0f);
		awb.setTotalPrepaid(824.0f);
		awb.setTotalCollect(824.0f);
		
		return awb;
    }  
    
    public static AWB buildEmptyAirwayBill(User u){
    	AirwayBill awb = new AirwayBill();
    	
   		awb.setUser(u);	
	    
    	Customer consignee = new Customer();
    	consignee.setUser(u);
    	Customer shipper = new Customer();       
    	shipper.setUser(u);
    	Customer airline = new Customer();
    	airline.setUser(u);
    	Customer agent = new Customer();
    	agent.setUser(u);
    	
		awb.setAgent(agent);
		awb.setConsignee(consignee);
		awb.setOtherParty(airline);
	 	awb.setShipper(shipper);   	

	 	awb.setHandlingInfoList(paddHandlingList(new ArrayList<HandlingInfo>()));
		awb.setAccountInfoList(paddAccountList(new ArrayList<AccountInfo>()));
		awb.setOtherCargesList(paddOtherChargesList(new ArrayList<OtherCharges>())); 
		awb.setRateLinesList(RateLineForm.paddRateLineList(new ArrayList<RateLineForm>()));
		
		for(RateLineForm rateLineForm: awb.getRateLinesList()){
			rateLineForm.setDims(RateLineForm.paddDimList(new ArrayList<Dimension>()));
		}
		
		return awb;
    }  	
}
