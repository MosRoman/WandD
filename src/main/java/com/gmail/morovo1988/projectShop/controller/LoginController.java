package com.gmail.morovo1988.projectShop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String errors, String logout) {
        if (errors != null) {
            model.addAttribute("errors", "Username or password are incorrect");
        }
        if (logout != null) {
            model.addAttribute("message", "Logged out Successfully");
        }
        return "./login";
    }
}

