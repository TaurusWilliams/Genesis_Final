package com.gcu.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.business.UserBusinessService;
import com.gcu.model.UserModel;



@Controller
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    UserBusinessService service;

    @GetMapping("/")
	public String display(Model model) {
		model.addAttribute("title","Register Form");
		model.addAttribute("registerModel",new UserModel());
		
		return "register";
	}

	@PostMapping("/doRegistration")
    public String doRegistration(@Valid UserModel UserModel, BindingResult bindingResult, Model model)
    {
		
        service.addUser(UserModel);    
        //Display the Orders View
        model.addAttribute("title", "Login");
        return "login";
		
	}
}
	
    

