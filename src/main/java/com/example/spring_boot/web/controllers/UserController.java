package com.example.spring_boot.web.controllers;

import com.example.spring_boot.web.model.User;
import com.example.spring_boot.web.service.UserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    private UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/profile")
    public String showUser(Model model, @AuthenticationPrincipal User user) {
        model.addAttribute("user", user);
        return "/user/user";
    }

}
