package com.gcu.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.business.ProductsBusinessInterface;
import com.gcu.model.ProductModel;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	public ProductsBusinessInterface productService;

	@GetMapping("/")
	public String display(Model model) {

		model.addAttribute("title","Admin Form");
		model.addAttribute("productModel",new ProductModel());
		return "admin";
	}

	@GetMapping("/add_game")
	public String displayAdd(Model model) {
		List<ProductModel> product = productService.getProduct();
		model.addAttribute("title","Admin Form");
		model.addAttribute("productModel",new ProductModel());
		model.addAttribute("games",product);
		return "add_game";
	}

	@GetMapping("/edit_game")
	public String displayEdit(Model model) {
		List<ProductModel> product = productService.getProduct();
		model.addAttribute("title","Admin Form");
		model.addAttribute("productModel",new ProductModel());
		model.addAttribute("games",product);
		return "edit_game";
	}

	@GetMapping("/remove_game")
	public String displayRemove(Model model) {
		List<ProductModel> product = productService.getProduct();
		model.addAttribute("title","Admin Form");
		model.addAttribute("productModel",new ProductModel());
		model.addAttribute("games",product);
		return "remove_game";
	}
	
	@PostMapping("/add_game/doAddProduct")
	public String doAddProduct(@Valid ProductModel productModel, BindingResult bindingResult, Model model)
    {
		productService.addGame(productModel);
		List<ProductModel> product = productService.getProduct();

		//List<ProductModel> games = productService.getList();
		model.addAttribute("title","Admin Form");
		model.addAttribute("games",product);
		
		return "add_game";
	}

	@PostMapping("/edit_game/doEditProduct")
	public String doEditProduct(@Valid ProductModel productModel, BindingResult bindingResult, Model model)
    {
		productService.edit(productModel);
		List<ProductModel> product = productService.getProduct();

		//List<ProductModel> games = productService.getList();
		model.addAttribute("title","Product Admin Form");
		model.addAttribute("games",product);
		
		return "edit_game";
	}

	@PostMapping("/remove_game/doRemoveProduct")
	public String doRemoveProduct(@Valid ProductModel productModel, BindingResult bindingResult, Model model)
    {
		
		productService.remove(productService.getProductById(productModel.getId()));
		List<ProductModel> product = productService.getProduct();

		//List<ProductModel> games = productService.getList();
		model.addAttribute("title","Product Admin Form");
		model.addAttribute("games",product);
		
		return "remove_game";
	}
}
