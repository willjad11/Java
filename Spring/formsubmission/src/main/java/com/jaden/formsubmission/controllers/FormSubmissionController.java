package com.jaden.formsubmission.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FormSubmissionController {
	
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}

	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(HttpSession session,
		@RequestParam(value="email") String email,
	    @RequestParam(value="password") String password) {
			session.setAttribute("email", email);
			return "redirect:/dashboard";
		}

	@RequestMapping("dashboard")
	public String dashboard(HttpSession session, Model model) {
		String email = (String) session.getAttribute("email");
		model.addAttribute("email", email);
		return "results.jsp";
	}
}
