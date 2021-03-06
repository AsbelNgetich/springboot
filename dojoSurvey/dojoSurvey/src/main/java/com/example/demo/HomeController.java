package com.example.demo;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String index() {
		
		return "index.jsp";
	}
	
	@RequestMapping(value = "/result", method = RequestMethod.POST)
	public String results(HttpSession session, @RequestParam(value="name") String name,@RequestParam(value="location") String location, 
						  @RequestParam(value="language") String language, @RequestParam(value="comments") String comments) {
		 
		session.setAttribute("name", name);
		session.setAttribute("location", location);
		session.setAttribute("language", language);
		session.setAttribute("comments", comments);
		 
		return "redirect:/results";
	}
	
	@RequestMapping("/results")
	public String showResults() {
		
		return "result.jsp";
	}
	

}
