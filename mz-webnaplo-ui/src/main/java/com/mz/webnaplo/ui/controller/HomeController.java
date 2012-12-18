package com.mz.webnaplo.ui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	

	@RequestMapping("/")
	public String getHomePage() {
		return "home";
	}
	
	@RequestMapping("/auth/welcome")
	public String getUserPage() {
		return "auth/welcome";
	}

	@RequestMapping("/admin/welcome")
	public String getAdminPage() {
		return "admin/welcome";
	}
}
