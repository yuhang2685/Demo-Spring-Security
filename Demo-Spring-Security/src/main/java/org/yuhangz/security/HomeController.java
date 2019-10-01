package org.yuhangz.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String Home() {
		
		// Spring Boot needs dependency to work with jsp, 
		// OW, it tries to download the returned data.
		return "home.jsp";
	}
}
