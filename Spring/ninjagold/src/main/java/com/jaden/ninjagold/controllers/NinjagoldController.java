package com.jaden.ninjagold.controllers;

import java.util.ArrayList;
import java.util.Random;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NinjagoldController {
	
	@RequestMapping("/gold")
	public String index(HttpSession session, Model model) {
		if (session.getAttribute("gold") == null) {
			session.setAttribute("gold", 0);
		}
		if (session.getAttribute("messages") == null) {
			ArrayList<String> messages = new ArrayList<String>();
			session.setAttribute("messages", messages);
		}
		model.addAttribute("gold", session.getAttribute("gold"));
		model.addAttribute("messages", session.getAttribute("messages"));
		return "ninjagold.jsp";
	}

	@RequestMapping(value="/process", method=RequestMethod.POST)
	public String process(
		HttpSession session, 
		@RequestParam(value="farm", required = false) boolean farm,
	    @RequestParam(value="cave", required = false) boolean cave,
	    @RequestParam(value="house", required = false) boolean house,
	    @RequestParam(value="casino", required = false) boolean casino) {
			Random rand = new Random();
			java.util.Date date = new java.util.Date();
			ArrayList<String> messages = (ArrayList<String>) session.getAttribute("messages");
			if (farm) {
				Integer randomGold = 10 + rand.nextInt((20 - 10) + 1);
				session.setAttribute("gold", (Integer) session.getAttribute("gold") + randomGold);
				messages.add("You went into a farm and earned " + randomGold + " gold. (" + date + ")");
				session.setAttribute("messages", messages);
			}
			else if (cave) {
				Integer randomGold = 5 + rand.nextInt((10 - 5) + 1);
				session.setAttribute("gold", (Integer) session.getAttribute("gold") + randomGold);
				messages.add("You went into a cave and earned " + randomGold + " gold. (" + date + ")");
				session.setAttribute("messages", messages);
			}
			else if (house) {
				Integer randomGold = 2 + rand.nextInt((5 - 2) + 1);
				session.setAttribute("gold", (Integer) session.getAttribute("gold") + randomGold);
				messages.add("You went into a house and earned " + randomGold + " gold. (" + date + ")");
				session.setAttribute("messages", messages);
			}
			else if (casino) {
				Integer winOrLose = 1 + rand.nextInt((10 - 1) + 1);
				Integer randomGold = 0 + rand.nextInt((50 - 0) + 1);
				if (winOrLose <= 5) {
					session.setAttribute("gold", (Integer) session.getAttribute("gold") - randomGold);
					messages.add("You went into a casino and lost " + randomGold + " gold. (" + date + ")");
					session.setAttribute("messages", messages);
				}
				else {
					session.setAttribute("gold", (Integer) session.getAttribute("gold") + randomGold);
					messages.add("You went into a casino and earned " + randomGold + " gold. (" + date + ")");
					session.setAttribute("messages", messages);
				}
			}
		return "redirect:/gold";
	}
}
