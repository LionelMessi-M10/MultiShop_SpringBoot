package com.multishop.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multishop.model.dto.UserDTO;

@Controller
@RequestMapping("/shop")
public class UserController {
	
	@GetMapping("/login")
	public String loginPage(UserDTO userDTO, Model model) {
		model.addAttribute("userDTO", userDTO);
		return "web/login";
	}

}
