/*
 * =============================================================================
 *
 *   Copyright (c) 2011, The THYMELEAF team (http://www.thymeleaf.org)
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 *
 * =============================================================================
 */
package com.easecargo.awb;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.easecargo.awb.service.AWBService;
import com.easecargo.awb.service.HAWBService;
import com.easecargo.user.User;
import com.easecargo.user.service.UserService;

   
@Controller
public class HAWBController {
	 
	@Autowired
	HAWBService hawbService;
	@Autowired
	AWBService awbService;
	@Autowired
	private UserService userService;

	
	public HAWBController() {
        super();
    }  	
	
 
    @RequestMapping({"/hawb"})
    public String showHAWB(final HAWB hawb,final BindingResult bindingResult, final ModelMap model) {		
    	System.out.println("Show HAWB" + hawb); 
    	System.out.println("Show AWB" + model.get("airwayBill"));      
    	model.addAttribute("hawb", buildHAWB()); 
        return "hawb";       
    }    
	
    @RequestMapping(value="/hawb", params={"viewHAWB"})
    public String viewHAWB(final HAWB hawb,final BindingResult bindingResult, final ModelMap model) {		
    	System.out.println("Show HAWB" + hawb);  
    	List<HAWB> list = new ArrayList<HAWB>();
    	list.add(buildHAWB());
    	list.add(buildHAWB());
    	model.addAttribute("hawbsForAWB", list);
    	model.addAttribute("hawb", buildHAWB());//buildAWB()   
        return "hawb";       
    }    
    
    @RequestMapping(value="/hawb", params={"shownew"})
    public String showNewHAWB(final HAWB hawb,final BindingResult bindingResult, final ModelMap model) {		
    	System.out.println("Show HAWB" + hawb);     
    	model.addAttribute("hawb", new HAWB());//buildAWB() 
        return "hawb";       
    }  
    @RequestMapping(value="/hawb", params={"modify"})
    public String modifyHAWB(final HAWB hawb,final BindingResult bindingResult, final ModelMap model) {		
    	System.out.println("Show AHWB" + hawb);     
    	model.addAttribute("hawb", hawb);//buildAWB() 
        return "hawb";       
    }      
    @RequestMapping(value="/hawb", params={"save"})
    public String saveHAWB(final HAWB hawb,final BindingResult bindingResult, final ModelMap model) {		
    	System.out.println("Show HAWB" + hawb.getAwbPrefix() + hawb.getAwbNumber());    
    	User u = userService.getUserByName("Me");
    	hawb.setUser(u);
    	hawb.getShipper().setUser(u);
    	hawb.getConsignee().setUser(u);
    	hawbService.saveHAWB(hawb);
    	
    	model.addAttribute("hawb", hawb);//buildAWB() 
        return "hawb";       
    }   
    @RequestMapping(value="/hawb", params={"delete"})
    public String deleteHAWB(final HAWB hawb,final BindingResult bindingResult, final ModelMap model) {		
    	System.out.println("Show HAWB" + hawb);     
    	hawbService.deleteHAWBByNumber(hawb.getHawbNum());
    	model.addAttribute("hawb", hawb);//buildAWB() 
        return "hawb";       
    }   
        
    @RequestMapping(value="/hawb", params={"showawb"})
    public String showAWBforHAWB(final HAWB hawb,final BindingResult bindingResult, final ModelMap model) {		
    	System.out.println("Show HAWB" + hawb);  
    	AWB awbresult = awbService.getAWB(hawb.getAwbPrefix(),hawb.getAwbNumber());
    	System.out.println("AWB Result" + awbresult);
    	User user = userService.getUserByName("Me");
    	awbresult.setUser(user);    
    	
    	model.addAttribute("airwayBill", AirwayBill.toForm(awbresult));
        return "awb";                            
    }     
    @RequestMapping(value="/hawb", params={"message"})
    public String showMessageforHAWB(final HAWB hawb,final BindingResult bindingResult, final ModelMap model) {		
    	System.out.println("Show AWB" + hawb);     
    	model.addAttribute("hawb", hawb);//buildAWB() 
        return "message";       
    } 
     
     
    
    
    public static HAWB buildHAWB(){
    	HAWB hAWB = new HAWB();
    	
    	//hAWB.setAwb(awb)
    	//AWB awb = new AWB();
    	hAWB.setAwbNumber(22334567);
    	hAWB.setAwbPrefix(124);
    	//hAWB.setAwb(awb);
    	
    	hAWB.setCharge("23");

    	hAWB.setContactPerson("Gikenson");
    	hAWB.setContactPhone("24443222");
    	hAWB.setCurrency("EUR");
    	hAWB.setDeclaredValueCarrier(32.2f);
    	hAWB.setDeclaredValueCustomer(23.3f);
    	hAWB.setDepartureAirportCode("LHR");
    	hAWB.setDestinationAirportCode("YUL");     
    	hAWB.setDimensionUnit("M");
    	hAWB.setFlightDate(new Timestamp(new Date().getTime()));
    	hAWB.setFlightNumber("BA0222");
    	hAWB.setHarmonizedCode("HAR");
    	hAWB.setHawbNum("2323333");
    	hAWB.setHeight(22.4f);
    	hAWB.setInsuredAmount(433.3f);
    	hAWB.setLength(32.4f);
    	hAWB.setNatureOfGoods("Cloths");
    	hAWB.setOciInfo("no info");
    	hAWB.setPieces(12);
    	hAWB.setRemarks("No additonal remarks");
    	hAWB.setWeight(12.4f);
    	hAWB.setVolume(33.5f);
    	hAWB.setWidth(33.5f);
    	
    	hAWB.setTotalGrossWeight(66.7f);
    	hAWB.setTotalGrossWeightUnit("Kg");
    	hAWB.setTotalPieces(22);
    	hAWB.setTotalShipmentGrossCount(2);
    	
		Customer shipper = new Customer();
		//shipper.setUser(u);
		shipper.setCustomerName("Fashion");
		shipper.setAddress("#10,Nile St. Airport Road");
		shipper.setCityName("Madrid");
		shipper.setContactName("Gradia");
		shipper.setCountryName("Spain");
		shipper.setEmail("info@fashion.com");
		shipper.setPhoneNumber(82389329);//change integer
		shipper.setPoBox(1232);
		shipper.setAccountNumber("233332322");
		
		Customer consignee = new Customer();
		//consignee.setUser(u);
		consignee.setCustomerName("Wild Mart");
		consignee.setAddress("#10,Elstra St. Mount Road");
		consignee.setCityName("Toronto");
		consignee.setContactName("Silvester");
		consignee.setCountryName("Canada");
		consignee.setEmail("info@wildmart.com");
		consignee.setPhoneNumber(82879329);//change integer
		consignee.setPoBox(1222);
		consignee.setAccountNumber("88886644");

    	hAWB.setConsignee(consignee);
    	hAWB.setShipper(shipper);
    	
    	return hAWB;
    }
    
    

}


