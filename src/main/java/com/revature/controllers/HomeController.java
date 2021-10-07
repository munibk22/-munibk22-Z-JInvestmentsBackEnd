package com.revature.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class HomeController {

	@GetMapping(value = { "/hello", "/users/hello" })
	public String homePage(@RequestParam(value = "name", defaultValue = "World", required = true) String name,
			Model model) {
		System.out.println("Testing2 home page");
		model.addAttribute("name", name);
		return "home";
	}

	@GetMapping("/testlogin")
	public String loginPage() {
		return "home.jsp";
	}

	@RequestMapping("/logout")
	public void logoutPage() {
		System.out.println("Logging out");
	}
}
