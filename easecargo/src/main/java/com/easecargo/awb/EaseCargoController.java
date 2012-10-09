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
import java.util.Date;
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
public class EaseCargoController {
	 
	@Autowired
	AWBService awbService;
	@Autowired
	private UserService userService;
	
	public EaseCargoController() {
        super();
    }


       
    
    @RequestMapping({"/message"})
    public String showMessage(final AWB awb,final BindingResult bindingResult, final ModelMap model) {		
    	System.out.println("Show HAWB" + awb);     
    	awb.setAwbNumber(12344422);      
    	model.addAttribute("awb", awb);//buildAWB() 
        return "message";       
    }  
    

    @RequestMapping({"/citymaster"})
    public String showCityMaster(final AWB awb,final BindingResult bindingResult, final ModelMap model) {		
    	System.out.println("Show HAWB" + awb);     
    	awb.setAwbNumber(12344422);      
    	model.addAttribute("awb", awb);//buildAWB() 
        return "citymaster";       
    }  
  
    @RequestMapping({"/codemaster"})
    public String showCodemaster(final AWB awb,final BindingResult bindingResult, final ModelMap model) {		
    	System.out.println("Show HAWB" + awb);     
    	awb.setAwbNumber(12344422);      
    	model.addAttribute("awb", awb);//buildAWB() 
        return "codemaster";       
    }      
 
    @RequestMapping({"/currencymaster"})
    public String showCurrencyMaster(final AWB awb,final BindingResult bindingResult, final ModelMap model) {		
    	System.out.println("Show HAWB" + awb);     
    	awb.setAwbNumber(12344422);      
    	model.addAttribute("awb", awb);//buildAWB() 
        return "currencymaster";       
    }      

    @RequestMapping({"/myaccount"})
    public String showMyAccount(final AWB awb,final BindingResult bindingResult, final ModelMap model) {		
    	System.out.println("Show HAWB" + awb);     
    	    
    	model.addAttribute("awb", awb);//buildAWB() 
        return "myaccount";       
    }  
    
    @RequestMapping({"/myawbs"})
    public String showMyAwbs(final AWB awb,final BindingResult bindingResult, final ModelMap model) {		
    	System.out.println("Show HAWB" + awb);     
    	      
    	model.addAttribute("awb", awb);//buildAWB() 
        return "myawbs";       
    }     
 
    @RequestMapping(value="/myawbs", params={"awb"})
    public String showAwbFromAWBs(final AWB awb,final BindingResult bindingResult, final ModelMap model) {		
    	System.out.println("Show HAWB" + awb);     
       
    	model.addAttribute("awb", awb);//buildAWB() 
        return "awb";       
    }  
    
    
    @RequestMapping({"/mybillings"})
    public String showBilling(final AWB awb,final BindingResult bindingResult, final ModelMap model) {		
    	System.out.println("Show HAWB" + awb);     
         
    	model.addAttribute("awb", awb);//buildAWB() 
        return "mybillings";         
    }      
    
    @RequestMapping({"/mycustomers"})
    public String showMyCustomers(final AWB awb,final BindingResult bindingResult, final ModelMap model) {		
    	System.out.println("Show HAWB" + awb);     
     
    	model.addAttribute("awb", awb);//buildAWB() 
        return "mycustomers";       
    }     
    @RequestMapping(value="/mymessages", params={"message"})
    public String showMyMessageFromMessages(final AWB awb,final BindingResult bindingResult, final ModelMap model) {		
    	System.out.println("Show HAWB" + awb);     
    	    
    	model.addAttribute("awb", awb);//buildAWB() 
        return "message";       
    }  
    
    @RequestMapping({"/mypayments"})
    public String showMyPayments(final AWB awb,final BindingResult bindingResult, final ModelMap model) {		
    	System.out.println("Show HAWB" + awb);     
    	    
    	model.addAttribute("awb", awb);//buildAWB() 
        return "mypayments";       
    }  
    
    @RequestMapping({"/myprofile"})
    public String showMyProfile(final AWB awb,final BindingResult bindingResult, final ModelMap model) {		
    	System.out.println("Show HAWB" + awb);     
    	 
    	model.addAttribute("awb", awb);//buildAWB() 
        return "myprofile";       
    }  
    
    
    
    
    
    

}
