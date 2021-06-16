package com.assignments.theCode;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class HomeController {
	@RequestMapping("/")
	public String index() {
		
		return "index.jsp";
	}
	
    @RequestMapping(value="/login", method=RequestMethod.POST)
    public String login(@RequestParam(value="code") String code) {
        
    	if(code.equals("bushido")) {
    		
          return "redirect:/code";
    	}else {
    		return "redirect:/createError";
    	}
    	
    	
    }
    
    @RequestMapping("/code")
    public String bushidoCode() {
    	
    	
    	return "code.jsp";
    }
    
    @RequestMapping("/createError")
    public String flashMessages(RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("invalidCode", "You must train harder!");
        return "redirect:/";
    }

}
