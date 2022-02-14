package com.jaden.springboottemplate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SpringBootTemplateController {
	 @RequestMapping("/")
	 public String home(Model model) {
		 model.addAttribute("fruit","banana");
		 return "index.jsp";
	 }
}

