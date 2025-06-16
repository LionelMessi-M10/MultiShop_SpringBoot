package com.multishop.controller.seller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multishop.service.ProductService;

@Controller
@RequestMapping("/seller")
public class SellerController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping
	public String sellerPage() {
		return "seller/index";
	}
	
	@GetMapping("/products")
	public String productPage(Model model) {
		model.addAttribute("products", productService.getAllProducts());
		return "seller/product-list";
	}
	
	@GetMapping("/categories")
	public String categoryPage() {
		return "seller/category-list";
	}
	
	@GetMapping("/orders")
	public String orderPage() {
		return "seller/order-list";
	}
}
