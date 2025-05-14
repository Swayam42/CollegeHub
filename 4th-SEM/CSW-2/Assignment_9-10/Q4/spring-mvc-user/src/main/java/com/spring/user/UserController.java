package com.spring.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @GetMapping("/user")
    public String showForm(Model model) {
        model.addAttribute("user", new User());
        return "user-form";
    }

    @PostMapping("/user")
    public String submitForm(@ModelAttribute("user") User user, Model model) {
        model.addAttribute("name", user.getName());
        model.addAttribute("email", user.getEmail());
        return "user-details";
    }
}
