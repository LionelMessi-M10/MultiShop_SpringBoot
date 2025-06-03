package com.multishop.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multishop.model.dto.UserDTO;

@Controller
@RequestMapping("/shop")
public class HomeController {

	
	@GetMapping("/home")
	public String homePage(UserDTO userDTO, Model model) {
		model.addAttribute("userDTO", userDTO);
		return "web/index";
	}
	
	@GetMapping("/products")
	public String shopPage(UserDTO userDTO, Model model) {
		model.addAttribute("userDTO", userDTO);
		return "web/shop";
	}
	
	@GetMapping("/orders")
	public String orderPage(UserDTO userDTO, Model model) {
		model.addAttribute("userDTO", userDTO);
		return "web/order";
	}
	
	@GetMapping("/checkout")
	public String checkoutPage(UserDTO userDTO, Model model) {
		model.addAttribute("userDTO", userDTO);
		return "web/checkout";
	}
	
	@GetMapping("/carts")
	public String cartPage(UserDTO userDTO, Model model) {
		model.addAttribute("userDTO", userDTO);
		return "web/cart";
	}
	
	@GetMapping("/wishlist")
	public String wishlistPage(UserDTO userDTO, Model model) {
		model.addAttribute("userDTO", userDTO);
		return "web/wishlist";
	}
	
	@GetMapping("/product")
	public String productDetailPage(UserDTO userDTO, Model model) {
		model.addAttribute("userDTO", userDTO);
		return "web/detail";
	}
}
