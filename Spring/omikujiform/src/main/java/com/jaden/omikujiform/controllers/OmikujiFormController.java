package com.jaden.omikujiform.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class OmikujiFormController {
	
	@RequestMapping("/omikuji")
	public String index() {
		return "index.jsp";
	}

	@RequestMapping(value="/process", method=RequestMethod.POST)
	public String process(
		HttpSession session, 
		RedirectAttributes redirectAttributes,
		@RequestParam(value="number") String number,
	    @RequestParam(value="cityName") String cityName,
	    @RequestParam(value="personName") String personName,
	    @RequestParam(value="personalHobby") String personalHobby,
	    @RequestParam(value="livingThing") String livingThing,
	    @RequestParam(value="niceThing") String niceThing) {
			boolean valid = true;

			if (number.equals("")) {
				redirectAttributes.addFlashAttribute("noNumber", "You must choose a number!");
				valid = false;
			}

			if (cityName.equals("")) {
				redirectAttributes.addFlashAttribute("noCityName", "You must enter a city name!");
				valid = false;
			}

			if (personName.equals("")) {
				redirectAttributes.addFlashAttribute("noPersonName", "You must enter a person's name!");
				valid = false;
			}

			if (personalHobby.equals("")) {
				redirectAttributes.addFlashAttribute("noPersonalHobby", "You must enter a hobby or endeavor!");
				valid = false;
			}

			if (livingThing.equals("")) {
				redirectAttributes.addFlashAttribute("noLivingThing", "You must enter a living thing!");
				valid = false;
			}

			if (niceThing.equals("")) {
				redirectAttributes.addFlashAttribute("noNiceThing", "You must enter a nice thing!");
				valid = false;
			}

			if (valid == false) {
				return "redirect:/omikuji";
			}

			else {
				session.setAttribute("number", number);
				session.setAttribute("cityName", cityName);
				session.setAttribute("personName", personName);
				session.setAttribute("personalHobby", personalHobby);
				session.setAttribute("livingThing", livingThing);
				session.setAttribute("niceThing", niceThing);
				return "redirect:/omikuji/show";
			}
		}

	@RequestMapping("/omikuji/show")
	public String dashboard(HttpSession session, Model model) {
		model.addAttribute("number", session.getAttribute("number"));
		model.addAttribute("cityName", session.getAttribute("cityName"));
		model.addAttribute("personName", session.getAttribute("personName"));
		model.addAttribute("personalHobby", session.getAttribute("personalHobby"));
		model.addAttribute("livingThing", session.getAttribute("livingThing"));
		model.addAttribute("niceThing", session.getAttribute("niceThing"));
		return "results.jsp";
	}
}
