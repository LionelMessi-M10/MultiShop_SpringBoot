package com.multishop.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multishop.entity.User;
import com.multishop.model.dto.UserDTO;
import com.multishop.service.UserService;

@Controller
@RequestMapping("/shop")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/login")
	public String loginPage() {
		return "web/login";
	}
	
	@GetMapping("/register")
	public String registerPage(UserDTO userRegister, Model model) {
		model.addAttribute("user", userRegister);
		return "web/register";
	}
	
	@PostMapping("/register")
	public String handleRegister(@ModelAttribute("user") UserDTO userRegister) {
		userService.registerAccount(userRegister);
		return "redirect:/shop/login";
	}
}
