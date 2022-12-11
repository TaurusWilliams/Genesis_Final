package com.gcu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {
    /**
     * This is the default landing page for the application at the / mapping
     * @param model
     * @return
     */
    @GetMapping("/")
    public String display(Model model) {
        model.addAttribute("title","Home");
        return "home";
    }
}