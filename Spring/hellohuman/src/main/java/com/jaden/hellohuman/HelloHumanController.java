package com.jaden.hellohuman;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/")
public class HelloHumanController {
	 @RequestMapping("")
	 public String name(
			 @RequestParam(value="name", required=false) String name,
			 @RequestParam(value="last_name", required=false) String last_name,
			 @RequestParam(value="times", required=false) Integer times) {
		 String output = "";
		 if (times == null) {
			 times = 1;
		 }
		 if (name == null) {
			 for (int i = 0; i < times; i++) {
				 output += "hello Human ";
			 }
			 return output;
		 }
		 else if (name != null && last_name != null) {
			 for (int i = 0; i < times; i++) {
				 output += "Hello " + name + " " + last_name + " ";
			 }
			 return output;
		 }
		 else {
			 for (int i = 0; i < times; i++) {
				 output += "Hello " + name + " ";
			 }
			 return output;
		 }
	 }
	 @RequestMapping("test/{test}")
	 public String showLesson(@PathVariable("test") String test) {
		 return "param: " + test;
	 }
}

