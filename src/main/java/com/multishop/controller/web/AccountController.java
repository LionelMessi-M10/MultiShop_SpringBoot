package com.multishop.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/shop")
public class AccountController {

    @GetMapping("/login")
    public String showLoginPage() {
        return "web/login";
    }

    @GetMapping("/register")
    public String showRegisterPage() {
        return "web/register";
    }
}
