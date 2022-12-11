package com.gcu.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gcu.model.OrderList;
import com.gcu.model.ProductModel;

@RestController
@RequestMapping("/service")
public class ProductsRestService {

	@Autowired
	public ProductsBusinessInterface service;
	
	@GetMapping(path="/getjson", produces= {MediaType.APPLICATION_JSON_VALUE})
	public List<ProductModel> getOrdersAsJson(){
		return service.getProduct();
	}
	
	@GetMapping(path="/getxml", produces= {MediaType.APPLICATION_XML_VALUE})
	public OrderList getOrdersAsXml(){
		OrderList list = new OrderList();
		list.setOrders(service.getProduct());
		return list;
	}
	
	@GetMapping(path="/getorder/{id}")
	public ResponseEntity<?> getOrder(@PathVariable("id") String id){
	    
	    try {
	        ProductModel order = service.getProductById(id);
	        if(order == null)
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        else 
	            return new ResponseEntity<>(order, HttpStatus.OK);        
	    }
	    catch (Exception e) 
	    {	        
	        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
}
