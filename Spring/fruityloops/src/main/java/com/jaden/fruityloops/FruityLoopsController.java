package com.jaden.fruityloops;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FruityLoopsController {
 
	@RequestMapping("/")
	public String index(Model model, HttpSession session) {
	     
	     ArrayList<Item> fruits = new ArrayList<Item>();
	     fruits.add(new Item("Kiwi", 1.5));
	     fruits.add(new Item("Mango", 2.0));
	     fruits.add(new Item("Goji Berries", 4.0));
	     fruits.add(new Item("Guava", .75));
	     
	     model.addAttribute("fruits", fruits);
	     session.setAttribute("pear", "apple");
	     
	     return "index.jsp";
	}
}

