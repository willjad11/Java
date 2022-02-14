package com.jaden.counter.controllers;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CounterController {
	@RequestMapping("/")
	public String index(HttpSession session){
		if (session.getAttribute("count") == null) {
				session.setAttribute("count", 0);
		}
		else {
				Integer incrementer = (Integer) session.getAttribute("count") + 1;
				session.setAttribute("count", incrementer);
		}
		return "Index.jsp";
	}

	@RequestMapping("counter")
	public String counter(HttpSession session, Model model) {
		Integer currentCount = (Integer) session.getAttribute("count");
		if (currentCount == null) {
			currentCount = 0;
		}
		model.addAttribute("countToShow", currentCount);
		return "Counter.jsp";
	}
	
	@RequestMapping("counter2")
	public String doublecounter(HttpSession session){
		if (session.getAttribute("count") == null) {
				session.setAttribute("count", 0);
		}
		else {
				Integer incrementer = (Integer) session.getAttribute("count") + 2;
				session.setAttribute("count", incrementer);
		}
		return "Index.jsp";
	}
}

