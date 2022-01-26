package com.sportsshop.service;

import java.util.List;
import java.util.Map;

import com.sportsshop.model.Product;

/**
 * These Services are provided by sports shop application.
 */
public interface ShopServices {
	
    Map<String, List<Product>> addProduct(Product product);
		
    Product selectProduct(Product product);
		
    Map<String, List<Product>> updateProductPrice(Product product);
		
    Map<String, List<Product>> removeProduct(Product product);
}

