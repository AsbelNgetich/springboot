package com.assignments.displayDate;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController {
	
	
	
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping("/date")
	public String date(Model model) {
		LocalDateTime today = LocalDateTime.now();
	
		DateTimeFormatter todayFormat = DateTimeFormatter.ofPattern("EEEE, dd MMMM yyyy"); 
		String formatedDate = today.format(todayFormat);
		
		model.addAttribute("date", formatedDate);
		
		
		return "date.jsp";
	}
	
	@RequestMapping("/time")
	public String time(Model model){
		
		DateFormat dateFormat = new SimpleDateFormat("hh:mm aa");
    	String time = dateFormat.format(new Date()).toString();
		
		model.addAttribute("time", time);
		return "time.jsp";
	}
	

}
