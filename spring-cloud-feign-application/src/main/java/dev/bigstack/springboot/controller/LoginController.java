package dev.bigstack.springboot.controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @GetMapping("/")
    public String showLoginPage(ModelMap model) {
        model.put("name", "Big Stack");
        return "welcome";
    }

}