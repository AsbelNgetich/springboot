package com.assignments.strings;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class StringsApplication {

	public static void main(String[] args) {
		SpringApplication.run(StringsApplication.class, args);
	}

	@RequestMapping("/")
	public String hello() {
		return "Hi! Welcome to our site.";
	}
	
	@RequestMapping("/random")
	public String randomRoute() {
		return "Spring boot is awesome!";
	}
}
