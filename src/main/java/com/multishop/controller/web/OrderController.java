package com.multishop.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.multishop.entity.Order;
import com.multishop.service.EmailService;

import jakarta.mail.MessagingException;

@RestController
public class OrderController {

	@Autowired
	private EmailService emailService;
	
	@GetMapping("/send-email")
	public String sendMail() throws MessagingException {
		Order order = new Order();
		order.setId(1L);
		emailService.sendOrderConfirmation("luongthanhhuyptit@gmail.com", "luongthanhhuyptit@gmail.com", "Don hang cua ban", "Don dat hang");
		return "sended mail";
	}
}
