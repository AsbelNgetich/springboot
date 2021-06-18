package com.assignments.languages.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.assignments.languages.models.Language;
import com.assignments.languages.services.LanguageService;

@Controller
public class LanguagesController {
    private final LanguageService languageService;
    
    public LanguagesController(LanguageService languageService) {
        this.languageService = languageService;
    }
    
    //display all languages on main page
    @RequestMapping("/languages")
    public String index(Model model) {
        List<Language> languages = languageService.allLanguages();
        model.addAttribute("languages", languages);
        model.addAttribute("language", new Language());
        return "/languages/index.jsp";
    }
    
    //display form to add a new language
    @RequestMapping("/languages/new")
    public String newLanguage(@ModelAttribute("language") Language language) {
        return "/languages/new.jsp";
    }
    
    //add a new language
    @RequestMapping(value="/languages", method=RequestMethod.POST)
    public String create(@Valid @ModelAttribute("language") Language language, BindingResult result, Model model) {
        if (result.hasErrors()) {
        	model.addAttribute("languages", languageService.allLanguages());
            return "/languages/index.jsp";
        } else {
        	languageService.createLanguage(language);
            return "redirect:/languages";
        }
    }
    
//    //Show language information
//    @RequestMapping("/languages/{id}")
//	public String showLanguage(@PathVariable("id") Long id, Model model) {
//		model.addAttribute("language", languageService.findLanguage(id));
//		return "/languages/show.jsp";
//	}
    
    //Edit language
    @RequestMapping("/languages/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
    	Language language = languageService.findLanguage(id);
        model.addAttribute("language", language);
        return "/languages/edit.jsp";
    }
    
//	@RequestMapping(value="/books/{id}", method=RequestMethod.PUT)
//	public String update(@Valid @ModelAttribute("book") Book book, BindingResult result) {
//    
    //Update language by id
    @RequestMapping(value="/languages/{id}", method=RequestMethod.PUT)
    public String update(@Valid @ModelAttribute("language") Language language, BindingResult result) {
        if (result.hasErrors()) {
            return "/languages/edit.jsp";
        } else {
        	languageService.updateLanguage(language);
            return "redirect:/languages";
        }
    }
    
    //Delete language by id
    @RequestMapping(value="/languages/{id}", method=RequestMethod.DELETE)
    public String destroy(@PathVariable("id") Long id) {
    	languageService.deleteLanguage(id);
        return "redirect:/languages";
    }
    
}