package com.assignments.dojosAndNinjas.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.assignments.dojosAndNinjas.services.DojoService;
import com.assignments.dojosAndNinjas.services.NinjaService;

@Controller
public class HomeController {
	private final DojoService dojoService;
	private final NinjaService ninjaService;
	
	public HomeController(DojoService dojoService, NinjaService ninjaService) {
		this.dojoService = dojoService;
		this.ninjaService = ninjaService;
	}
	
//	public HomeController(NinjaService ninjaService) {
//		this.dojoService = null;
//		this.ninjaService = ninjaService;
//	}
	
	
	@RequestMapping("/")
	public String index() {
		
		return "index.jsp";
	}
	
	
	
	
	
	
	
	
	
}
