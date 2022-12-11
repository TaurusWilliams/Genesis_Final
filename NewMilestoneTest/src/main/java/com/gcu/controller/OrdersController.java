package com.gcu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.business.ProductsBusinessInterface;
import com.gcu.model.ProductModel;

@Controller
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private ProductsBusinessInterface service;
    
    @GetMapping("/display")
    public String display(Model model) {
        
        List<ProductModel> orders = service.getProduct();
        
        model.addAttribute("title","My Orders");
        model.addAttribute("orders", orders);
        return "orders";
    }
    
}
