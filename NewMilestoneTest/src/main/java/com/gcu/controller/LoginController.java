package com.gcu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * This class holds all of the mapping 
 * needed for logging in
 */
@Controller
public class LoginController {

    /**
     * This log in mapping which oppens the log in page
     * @param model
     * @return
     */
    @RequestMapping("/login")
    public String display(Model model) {

        model.addAttribute("title","Login");
        
        return "login";
    }
}
