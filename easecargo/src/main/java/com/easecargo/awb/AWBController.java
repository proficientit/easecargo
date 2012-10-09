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
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.easecargo.awb.service.AWBService;
import com.easecargo.user.User;
import com.easecargo.user.service.UserService;

   
@Controller
public class AWBController {
	 
	@Autowired
	AWBService awbService;
	@Autowired
	private UserService userService;
	
	public AWBController() {
        super();   
    }    
     
 
    @RequestMapping({"/","/awb"})              
    public String showAWB(final AirwayBill awb,final BindingResult bindingResult, final ModelMap model) {		
    	System.out.println("Show AWB" + awb);
    	model.addAttribute("airwayBill", AirwayBill.buildEmptyAirwayBill((userService.getUserByName("Me"))));
        return "awb";      
    }         
    @RequestMapping(value="/awb", params={"prefil"})            
    public String prefilAWB(final AirwayBill awb,final BindingResult bindingResult, final ModelMap model) {		
    	System.out.println("Show AWB" + awb);
    	model.addAttribute("airwayBill", AirwayBill.buildPrefilledAWB((userService.getUserByName("Me"))));
        return "awb";      
    }    
 
    @RequestMapping(value="/awb", params={"save"})
    public String saveAWB(@ModelAttribute("airwayBill")AirwayBill awb, final BindingResult bindingResult, final ModelMap model){
       	System.out.println("User "+ awb.getUser().getUserName());
    	User u = awb.getUser();
    	awb.getShipper().setUser(u);
    	awb.getConsignee().setUser(u);
    	awb.getAgent().setUser(u);
    	awb.getOtherParty().setUser(u);
    	
    	AWB awbEntity = awb.toModel();
    	awbService.saveAWB(awbEntity);

    	
    	model.addAttribute("airwayBill",AirwayBill.toForm(awbEntity));
        return "awb";
    }
  
    @RequestMapping(value="/awb", params={"query"})
    public String queryAWB(@ModelAttribute("airwayBill")AirwayBill awb, final BindingResult bindingResult, final ModelMap model){
    	System.out.println("AWB Number "+ awb.getAwbNumber());
    	AWB awbresult = awbService.getAWB(awb.getAwbPrefix(),awb.getAwbNumber());
    	User user = userService.getUserByName("Me");
    	if(awbresult != null){
	    	System.out.println("AWB Result" + awbresult);
	    	awbresult.setUser(user);	    	
	    	model.addAttribute("airwayBill", AirwayBill.toForm(awbresult));
    	} else {
    		model.addAttribute("airwayBill", AirwayBill.buildEmptyAirwayBill(user));
    	}   
        return "awb";                 
    }                
    
    @RequestMapping(value="/awb", params={"delete"})
    public String deleteAWB(@ModelAttribute("airwayBill")AirwayBill awb, final BindingResult bindingResult, final ModelMap model){
    	System.out.println("AWB Number "+ awb.getAwbNumber());
    	awbService.deleteAWBByNumber(awb.getAwbPrefix(),awb.getAwbNumber());    	
    	model.addAttribute("airwayBill", AirwayBill.buildEmptyAirwayBill((userService.getUserByName("Me"))));
        return "awb";            
    }
 
    @RequestMapping(value="/awb", params={"hawb"})
    public String captureHAWB(@ModelAttribute("airwayBill")AirwayBill awb, final BindingResult bindingResult, final ModelMap model){
    	System.out.println("AWB Number "+ awb.getAwbNumber());
    	model.addAttribute("airwayBill", awb); 
    	HAWB hawb = new HAWB();
    	hawb.setAwbNumber(awb.getAwbNumber());
    	hawb.setAwbPrefix(awb.getAwbPrefix());
    	hawb.setTotalPieces(awb.getTotalPieces());
    	hawb.setTotalGrossWeight(awb.getTotalGrossWeight());
    	AWB awbNew = new AWB();
    	awbNew.setAwbId(awb.getAwbId());
    	System.out.println("awb.getAwbId()" + awb.getAwbId());
    	hawb.setAwb(awbNew); 
    	model.addAttribute("hawb", hawb);
    	model.addAttribute("hawbsForAWB", HAWBController.buildHAWB());
        return "hawb";  
    }    
    @RequestMapping(value="/awb", params={"message"})
    public String showMessageView(@ModelAttribute("airwayBill")AirwayBill awb, final BindingResult bindingResult, final ModelMap model){
    	System.out.println("AWB Number "+ awb.getAwbNumber());
    	model.addAttribute("airwayBill", awb);  
        return "message";
    }    
    @RequestMapping(value="/awb", params={"modify"})
    public String modifyAWB(@ModelAttribute("airwayBill")AirwayBill awb, final BindingResult bindingResult, final ModelMap model){
    	System.out.println("AWB Number "+ awb.getAwbNumber());
    	User u = awb.getUser();
    	awb.getShipper().setUser(u);
    	awb.getConsignee().setUser(u);
    	awb.getAgent().setUser(u);
    	awb.getOtherParty().setUser(u);
    	    
    	awbService.saveAWB(awb.toModel());  
        return "awb";
    }   
    
    @RequestMapping(value="/awb", params={"shownew"})
    public String showNewView(@ModelAttribute("airwayBill")AirwayBill awb, final BindingResult bindingResult, final ModelMap model){
    	System.out.println("AWB Number "+ awb.getAwbNumber());    	 
    	model.addAttribute("airwayBill", AirwayBill.buildEmptyAirwayBill((userService.getUserByName("Me"))));
        return "awb";
    }     
    

                     
    

    
    

    
    
 


}
