package com.assignments.dojosAndNinjas.controllers;

import java.util.List;

import javax.validation.Valid;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.assignments.dojosAndNinjas.models.Dojo;
import com.assignments.dojosAndNinjas.models.Ninja;
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
		
		return "index.jsp";
	}
	
	@GetMapping("/dojos/new")
	public String newDojos(@ModelAttribute("newDojo") Dojo newDojo) {
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
	
	@GetMapping("/ninjas/new")
	public String newNinjas(Model model, HttpServletRequest request) {
		
		List<Dojo> dojos = dojoService.allDojos();
	    request.setAttribute("dojos", dojos);	
		model.addAttribute("newNinja", new Ninja());
		
		return "new_ninja.jsp";
	}
	
	@PostMapping("/ninja")
	public String createNinja(@Valid @ModelAttribute("newNinja") Ninja newNinja, BindingResult result) {
		if(result.hasErrors()) {
	
			return "newNinja.jsp";
		}
		
		ninjaService.createNinja(newNinja);
		return "redirect:/";
	}
	
	@GetMapping("/dojo/{id}")
    public String show(Model model, @PathVariable("id") Long id) {
		
        Dojo dojo = dojoService.findDojo(id);
        List<Ninja> ninjas = dojo.getNinjas();
        model.addAttribute("dojo", dojo);
        model.addAttribute("ninjas", ninjas);
        
        return "show.jsp";
	}
	
	
	
	
	
	
		
	
}
