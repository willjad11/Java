package com.jaden.authentication.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.jaden.authentication.models.LoginUser;
import com.jaden.authentication.models.User;
import com.jaden.authentication.repositories.UserRepository;
import com.jaden.authentication.services.UserService;

@Controller
public class HomeController {
 
	 @Autowired
	 private UserService userServ;
	 @Autowired
	 private UserRepository userRepo;
 
	 @GetMapping("/")
	 public String index(HttpSession session, Model model) {
		 
		 if (session.getAttribute("userId") != null) {
			 return "redirect:/home";
		 }
	     // Bind empty User and LoginUser objects to the JSP
	     // to capture the form input
	     model.addAttribute("newUser", new User());
	     model.addAttribute("newLogin", new LoginUser());
	     return "index.jsp";
	 }
	 
	 @GetMapping("/home")
	 public String home(HttpSession session, Model model) {
		 if (session.getAttribute("userId") == null) {
			 return "redirect:/";
		 }
	     model.addAttribute("user", userRepo.findById((Long) session.getAttribute("userId")).get());
	     return "home.jsp";
	 }
	 
	 @GetMapping("/logout")
	 public String logout(HttpSession session) {
		 session.removeAttribute("userId");
		 session.invalidate();
	     return "redirect:/";
	 }
	 
	 @PostMapping("/register")
	 public String register(@Valid @ModelAttribute("newUser") User newUser, 
	         BindingResult result, Model model, HttpSession session) {
		 
		 User user = userServ.register(newUser, result);
	     
	     if(result.hasErrors()) {
	         model.addAttribute("newLogin", new LoginUser());
	         return "index.jsp";
	     }
	     
	     session.setAttribute("userId", user.getId());
	 
	     return "redirect:/home";
	 }
	 
	 @PostMapping("/login")
	 public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
	         BindingResult result, Model model, HttpSession session) {
	     
	     User user = userServ.login(newLogin, result);
	 
	     if(result.hasErrors()) {
	         model.addAttribute("newUser", new User());
	         return "index.jsp";
	     }
	     
	     session.setAttribute("userId", user.getId());
	 
	     return "redirect:/home";
	 }
 
}
