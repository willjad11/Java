package com.jaden.dojosandninjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.jaden.dojosandninjas.models.Dojo;
import com.jaden.dojosandninjas.models.Ninja;
import com.jaden.dojosandninjas.services.DojoService;

@Controller
public class DojoController {
	
	@Autowired
	private DojoService dojoService;
	
	@GetMapping("/")
    public String redirect() {
		return "redirect:/dojos";
    }
	
	@GetMapping("/dojos")
    public String dojos(Model model, @ModelAttribute("dojo") Dojo dojo) {
		List<Dojo> dojoList = dojoService.allDojos();
		model.addAttribute("dojoList", dojoList);
		return "/dojos/index.jsp";
    }
	
	@GetMapping("/dojos/new")
    public String newdojo(@ModelAttribute("dojo") Dojo dojo) {
		return "/dojos/create.jsp";
    }
	
    @PostMapping("/dojos/create")
    public String createdojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
        if (result.hasErrors()) {
            return "/dojos/create.jsp";
        } else {
        	dojoService.createDojo(dojo);
            return "redirect:/dojos";
        }
    }
    
    @DeleteMapping("/dojos/{id}")
    public String destroy(@PathVariable("id") Long id) {
    	Dojo dojo = dojoService.findDojo(id);
    	if (dojo.getNinjas().size() != 0) {
    		for (Ninja ninja : dojo.getNinjas()) {
    			ninja.setDojo(null);
    		}
    	}
    	dojo.setNinjas(null);
    	dojoService.deleteDojo(id);
        return "redirect:/dojos";
    }
	
	@RequestMapping("/dojos/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
        Dojo dojo = dojoService.findDojo(id);
        model.addAttribute("dojo", dojo);
        return "/dojos/show.jsp";
    }
	
	@RequestMapping("/dojos/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
        Dojo dojo = dojoService.findDojo(id);
        model.addAttribute("dojo", dojo);
        return "/dojos/edit.jsp";
    }
    
    @PutMapping(value="/dojos/{id}")
    public String update(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
        if (result.hasErrors()) {
            return "/dojos/edit.jsp";
        } else {
        	dojoService.updateDojo(dojo);
            return "redirect:/dojos";
        }
    }
}