package com.assignments.routing;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class helloController {
	@RequestMapping("/your_server/")
	public String hello(@RequestParam(value="name", required=false) String name) {
		
		if(name != null) {
			return "Hello " + name;
		}else 
			return "Hello human!";
	}
	

}