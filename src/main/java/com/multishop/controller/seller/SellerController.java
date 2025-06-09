package com.multishop.controller.seller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/seller")
public class SellerController {
	
	@GetMapping
	public String sellerPage() {
		return "seller/index";
	}
	
	

}
