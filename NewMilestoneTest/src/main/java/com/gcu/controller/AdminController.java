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

/**
 * This takes the user to the admin page where they
 * can add, remove, and update games
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	public ProductsBusinessInterface productService;

	/**
	 * This is the default mapping where it displays the admin page
	 * @param model
	 * @return
	 */
	@GetMapping("/")
	public String display(Model model) {

		model.addAttribute("title","Admin Form");
		model.addAttribute("productModel",new ProductModel());
		return "admin";
	}

	/**
	 * This is the add game page mapping where it takes the user to add
	 * a game to the products
	 * @param model
	 * @return
	 */
	@GetMapping("/add_game")
	public String displayAdd(Model model) {
		List<ProductModel> product = productService.getProduct();
		model.addAttribute("title","Admin Form");
		model.addAttribute("productModel",new ProductModel());
		model.addAttribute("games",product);
		return "add_game";
	}

	/**
	 * This is the edit game page mapping where it takes the user to edit
	 * a game in the products
	 * @param model
	 * @return
	 */
	@GetMapping("/edit_game")
	public String displayEdit(Model model) {
		List<ProductModel> product = productService.getProduct();
		model.addAttribute("title","Admin Form");
		model.addAttribute("productModel",new ProductModel());
		model.addAttribute("games",product);
		return "edit_game";
	}

	/**
	 * This is the Remove game page mapping where it takes the user to go remove 
	 * a game from the products
	 * @param model
	 * @return
	 */
	@GetMapping("/remove_game")
	public String displayRemove(Model model) {
		List<ProductModel> product = productService.getProduct();
		model.addAttribute("title","Admin Form");
		model.addAttribute("productModel",new ProductModel());
		model.addAttribute("games",product);
		return "remove_game";
	}
	
	/**
	 * After hitting the add product button this method is called which sends the product model
	 * into the add game method in the ProductsBusinessInterface class to be converted into a product entity
	 * @param productModel
	 * @param bindingResult
	 * @param model
	 * @return
	 */
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

	/**
	 * After hitting the Edit product button this method is called which sends the product model
	 * into the edit method in the ProductsBusinessInterface class to be converted into a product entity
	 * @param productModel
	 * @param bindingResult
	 * @param model
	 * @return
	 */
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

	/**
	 * After hitting the remove product button this method is called. In the view the only thing that the user can
	 * input is a game id. so the method finds a product model with the same ID and them pases it into the remove function
	 * in the ProductsBusinessInterface
	 * @param productModel
	 * @param bindingResult
	 * @param model
	 * @return
	 */
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
