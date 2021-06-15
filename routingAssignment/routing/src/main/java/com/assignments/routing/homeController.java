package com.assignments.routing;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class homeController {
	
	@RequestMapping("/")
	public String home(Model model) {
		model.addAttribute("dojoName", "burbank");
		return "index.jsp";
	}

}
