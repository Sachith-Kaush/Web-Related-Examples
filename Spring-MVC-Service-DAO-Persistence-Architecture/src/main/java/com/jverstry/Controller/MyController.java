
package com.jverstry.Controller;

import com.jverstry.Item.MilliTimeItem;
import com.jverstry.Service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {
	
    @Autowired
    private MyService myService;

	@RequestMapping(value = "/")
	public String home(Model model) {
		
		model.addAttribute("PersistenceStatus", myService.getPersistenceStatus());
		
		return "index";
		
	}
	
    @RequestMapping(value = "/roundtrip")
    public String persistenceStatus(Model model) {
        
		MilliTimeItem retr = myService.createAndRetrieve();
		
//		StringBuilder sb = new StringBuilder("<br />");
//		for (Exception e : myService.getExceptions()) {
//			sb.append(e.toString()).append("<br />");
//		}
		
		model.addAttribute("Exceptions", myService.getExceptions());
		
		model.addAttribute("IsNull", (retr==null));
		model.addAttribute("RoundTrip", retr);
		
		return "roundtrip";
		
    }	
	
}