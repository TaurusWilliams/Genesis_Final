package com.gcu.business;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import com.gcu.data.ProductsDataSevice;
import com.gcu.data.entity.ProductEntity;
import com.gcu.model.ProductModel;

/**
 * This service wires the CRUD methods from the Data access layer to the presentation layer.
 */
public class ProductsBusinessService implements ProductsBusinessInterface {
    @Autowired
    ProductsDataSevice service;
    
	@Override
	public void init() {
		System.out.println("Init from the OrdersBusnessService");
	}
	
	@Override
	public void destroy() {
		System.out.println("Destroy from the OrdersBusnessService");
		
	}
	
	@Override
	public void test() {
		System.out.println("Hello from the OrdersBusnessService");

	}
	/**
	 * This Method uses the OrderDataSevice's find all method to create a list
	 * of ProductEntitys then reads them into a list of Product Models to safely 
	 * display to the presentation layer.
	 */
	@Override
	public List<ProductModel> getProduct() {
		List<ProductEntity> productsEntity = service.findAll();
		List<ProductModel> productsDomain = new ArrayList<ProductModel>();
		for(ProductEntity entity : productsEntity)
		{
		    productsDomain.add(new ProductModel(entity.getId(),entity.getProductName(),entity.getPrice(),entity.getImageURL()));
		}

		return productsDomain;
	}

	/**
	 * This method uses the OrderDataSevice's find by ID method which creates a product entity
	 * with info found at that identity in the database then returns the same info as a product model.
	 */
    @Override
    public ProductModel getProductById(String id) {
        ProductEntity productEntity = service.findById(id);
        return new ProductModel(productEntity.getId(),productEntity.getProductName(),productEntity.getPrice(),productEntity.getImageURL());
    }

	/**
	 * This method creates a product entity object with the info stored in the product 
	 * model from the presentation layer then uses the OrderDataSevice's create method to
	 * save that entity to the database.
	 */
	@Override
	public void addGame(@Valid ProductModel productModel) {
		ProductEntity productEntity = new ProductEntity(null, productModel.getProductName(),productModel.getPrice(),productModel.getImageURL());
		service.create(productEntity);
	}

	/**
	 * This method uses the OrderDataSevice's create method to replase a product at the spesified ID. 
	 */
	@Override
	public void edit(@Valid ProductModel productModel) {
		ProductEntity productEntity = new ProductEntity(productModel.getId(), productModel.getProductName(),productModel.getPrice(),productModel.getImageURL());
		service.create(productEntity);
	}

	/**
	 * this method takes a user model, copies it to a user entity then passes it into the OrderDataSevice's delete method to 
	 * delete it from the database.
	 */
	@Override
	public void remove(@Valid ProductModel productModel) {
		ProductEntity productEntity = new ProductEntity(productModel.getId(), productModel.getProductName(),productModel.getPrice(),productModel.getImageURL());
		service.delete(productEntity);
	}

}
