package com.assignments.languages.controllers;

import java.util.List;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.assignments.languages.models.Language;
import com.assignments.languages.services.LanguageService;




@RestController
public class LanguagesApiController {
	private final LanguageService languageService;

	public LanguagesApiController(LanguageService languageService) {
		super();
		this.languageService = languageService;
	}
	
	@RequestMapping("/api/languages")
	public List <Language> index(){
		return languageService.allLanguages();
	}
	
	@RequestMapping(value="/api/languages", method=RequestMethod.POST)
	public Language create(@RequestParam(value="name") String name, @RequestParam(value="creator") String creator, 
			@RequestParam(value="currentVersion") Double currentVersion) {
		Language language = new Language(name, creator, currentVersion);
	        return languageService.createLanguage(language);
	}
	
	@RequestMapping("/api/languages/{id}")
	public Language show(@PathVariable("id") Long id) {
		Language language = languageService.findLanguage(id);
	       return language;
	}
	
	@RequestMapping(value="/api/languages/{id}", method=RequestMethod.PUT)
    public Language update(@PathVariable("id") Long id, @RequestParam(value="name") String name, @RequestParam(value="creator") String creator, 
			@RequestParam(value="currentVersion") Double currentVersion) {
		Language language = languageService.updateLanguageApi(id, name, creator, currentVersion);
        return language;
    }
    
    @RequestMapping(value="/api/languages/{id}", method=RequestMethod.DELETE)
    public void destroy(@PathVariable("id") Long id) {
        languageService.deleteLanguage(id);
    }
	

}
