package com.gmail.morovo1988.projectShop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping(value = "/")
    public String wellcome(Model model) {
        return "./home";
    }

    @GetMapping(value = "registration")
    public String createNewUser(Model model){
        return "registration";
    }
}
