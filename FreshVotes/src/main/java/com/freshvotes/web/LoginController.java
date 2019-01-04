package com.freshvotes.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PostMapping;

import com.freshvotes.domain.User;
import com.freshvotes.service.UserService;

@Controller
public class LoginController {
	
	
	@Autowired
	private UserService userService;
	
	
	//@RequestMapping(value="/login",method=RequestMethod.GET)
	//@GetMapping(value="/login")
	@GetMapping("/login")
	public String login() {
		return "/login";
	}
	
	
	@GetMapping("/register")
	public String register(ModelMap model) {
		model.put("user", new User());
		return "register";
	}
	
	@PostMapping("/register")
	public String registerPost (@ModelAttribute User user) {
		System.out.println("The inputted User:= "+user);
		User savedUser = userService.save(user);
		System.out.println("The Saved    User:= "+savedUser);
		return "redirect:/login";
	}
	
}
