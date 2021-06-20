package com.assignments.dojosAndNinjas.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.assignments.dojosAndNinjas.models.Dojo;
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
	
	
	
	@GetMapping("/")
	public String index() {
		
		return "new_dojo.jsp";
	}
	
	@GetMapping("/dojos/new")
	public String newDojos(Model model) {
		model.addAttribute("newDojo", new Dojo()); 
		return "newDojo.jsp";
	}
	
	@PostMapping("/dojo")
	public String create(@Valid @ModelAttribute("newDojo") Dojo newDojo, BindingResult result, Model model) {
		if(result.hasErrors()) {
			// still display notes if validation error
		//	model.addAttribute("allNotes", noteServ.getAll()); 
			return "newDojo.jsp";
		}
		// otherwise create a note and redirect back
		dojoService.createDojo(newDojo);
		return "redirect:/";
	}
	
	
	
	
	
	
	
	
	
	
}
