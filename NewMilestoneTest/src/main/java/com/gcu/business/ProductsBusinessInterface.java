package com.gcu.business;

import java.util.List;

import javax.validation.Valid;

import com.gcu.model.ProductModel;

public interface ProductsBusinessInterface {
	public void test();
	public List<ProductModel> getProduct();
	public ProductModel getProductById(String id);
	void init();
	public void destroy();
	public void addGame(@Valid ProductModel productModel);
    public void edit(@Valid ProductModel productModel);
    public void remove(@Valid ProductModel productModel);
}
