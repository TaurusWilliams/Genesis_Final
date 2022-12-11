package com.gcu.model;

public class ProductModel {
	
	String id = "";
	String productName = "";
	float price = 0;
	String imageURL = "";
	
	/**
	 * @param id
	 * @param productName
	 * @param price
	 * @param imageURL
	 */
	public ProductModel(String id, String productName, float price, String imageURL) {
		super();
		this.id = id;
		this.productName = productName;
		this.price = price;
		this.imageURL = imageURL;
	}

	public ProductModel() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
	
	
}
