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
import com.jaden.dojosandninjas.services.NinjaService;

@Controller
public class NinjaController {
	
	@Autowired
	private NinjaService ninjaService;
	@Autowired
	private DojoService dojoService;
	
	@GetMapping("/ninjas")
    public String ninjas(Model model, @ModelAttribute("ninja") Ninja ninja) {
		List<Ninja> ninjaList = ninjaService.allNinjas();
		model.addAttribute("ninjaList", ninjaList);
		return "/ninjas/index.jsp";
    }
	
	@GetMapping("/ninjas/new")
    public String newninja(@ModelAttribute("ninja") Ninja ninja, Model model) {
		List<Dojo> dojoList = dojoService.allDojos();
		model.addAttribute("dojoList", dojoList);
		return "/ninjas/create.jsp";
    }
	
    @PostMapping("/ninjas/create")
    public String createninja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result) {
        if (result.hasErrors()) {
            return "/ninjas/create.jsp";
        } else {
        	ninjaService.createNinja(ninja);
            return "redirect:/ninjas";
        }
    }
    
    @DeleteMapping("/ninjas/{id}")
    public String destroy(@PathVariable("id") Long id) {
    	ninjaService.deleteNinja(id);
        return "redirect:/ninjas";
    }
	
	@RequestMapping("/ninjas/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
        Ninja ninja = ninjaService.findNinja(id);
        model.addAttribute("ninja", ninja);
        return "/ninjas/show.jsp";
    }
	
	@RequestMapping("/ninjas/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
        Ninja ninja = ninjaService.findNinja(id);
        List<Dojo> dojoList = dojoService.allDojos();
		model.addAttribute("dojoList", dojoList);
        model.addAttribute("ninja", ninja);
        return "/ninjas/edit.jsp";
    }
    
    @PutMapping(value="/ninjas/{id}")
    public String update(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result) {
        if (result.hasErrors()) {
            return "/ninjas/edit.jsp";
        } else {
        	ninjaService.updateNinja(ninja);
            return "redirect:/ninjas";
        }
    }
}