package com.jaden.daikichiroutes;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/daikichi")
public class DaikichiController {
	 @RequestMapping("")
	 public String index(){
	   return "Welcome!";
	 }
	 @RequestMapping("/today")
	 public String today(){
	   return "Today you will find luck in all your endeavors!";
	 }
	 @RequestMapping("/tomorrow")
	 public String tomorrow(){
	   return "Tomorrow, an opportunity will arise, so be sure to be open to new ideas!";
	 }
	 @RequestMapping("/search")
	 public String index(@RequestParam(value="q", required=false) String searchQuery) {
	 	return "You searched for: " + searchQuery;
	 }
	 @RequestMapping("/travel/{place}")
	 public String travel(@PathVariable("place") String place) {
		 return "Congratulations! You will soon travel to " + place + "!";
	 }
	 @RequestMapping("lotto/{number}")
	 public String showLesson(@PathVariable("number") Integer number) {
		 if (number % 2 == 0) {
			 return "You will take a grand journey in the near future, but be weary of tempting offers.";
		 }
		 else {
			 return "You have enjoyed the fruits of your labor but now is a great time to spend time with family and friends.";
		 }
	 }
}

