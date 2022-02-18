package com.jaden.languages.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jaden.languages.models.Language;
import com.jaden.languages.services.LanguageService;

@Controller
public class LanguagesController {
	private final LanguageService languageService;
	public LanguagesController(LanguageService languageService){
        this.languageService = languageService;
    }
	
	@GetMapping("/languages")
    public String index(Model model, @ModelAttribute("language") Language language) {
		List<Language> languageList = languageService.allLanguages();
		model.addAttribute("languageList", languageList);
		return "index.jsp";
    }
    @PostMapping("/languages/create")
    public String create(@Valid @ModelAttribute("language") Language language, BindingResult result, Model model) {
        if (result.hasErrors()) {
        	List<Language> languageList = languageService.allLanguages();
    		model.addAttribute("languageList", languageList);
            return "index.jsp";
        } else {
        	languageService.createLanguage(language);
            return "redirect:/languages";
        }
    }
    
    @DeleteMapping("/languages/{id}")
    public String destroy(@PathVariable("id") Long id) {
    	languageService.deleteLanguage(id);
        return "redirect:/languages";
    }
	
	@RequestMapping("/languages/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
        Language language = languageService.findLanguage(id);
        model.addAttribute("language", language);
        return "show.jsp";
    }
	
	@RequestMapping("/languages/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
        Language language = languageService.findLanguage(id);
        model.addAttribute("language", language);
        return "edit.jsp";
    }
    
    @PutMapping(value="/languages/{id}")
    public String update(@Valid @ModelAttribute("language") Language language, BindingResult result) {
        if (result.hasErrors()) {
            return "edit.jsp";
        } else {
        	languageService.updateLanguage(language);
            return "redirect:/languages";
        }
    }
}