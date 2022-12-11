package com.gcu.data.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * This is the product entity class which takes data from the 
 * business layer and transmits it to the data access layer
 */
@Document(collection="products")
public class ProductEntity {
    @Id
    String id;
    String productName;
    float price;
    String imageURL;
    
    
    public ProductEntity() {
        
    }

    public ProductEntity(String id, String productName, float price, String imageURL) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.imageURL = imageURL;
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
