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


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
 

@Controller
public class SampleController {



	public SampleController() {  
        super();
    }

  @RequestMapping({"/sample"})
    public String showSeedstarters(final Sample seedStarter,final BindingResult bindingResult, ModelMap map) {
	  seedStarter.getSampleInners().add(new SampleInner("1","1"));
	  seedStarter.getSampleInners().add(new SampleInner("2","2"));   
	  seedStarter.getSampleInners().add(new SampleInner("3","3"));
	//  map.addAttribute("sample",seedStarter);
       // seedStarter.setDatePlanted(Calendar.getInstance().getTime());
        return "sample";
    }  

    @RequestMapping(value="/sample", params={"addRow"})
    public String addRow(final Sample seedStarter, final BindingResult bindingResult, ModelMap map) {
        seedStarter.getSampleInners().add(new SampleInner());
     //   map.addAttribute("sample",seedStarter);
        return "sample";
    }
    
}
    