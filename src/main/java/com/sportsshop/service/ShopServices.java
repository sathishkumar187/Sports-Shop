package com.sportsshop.service;

import java.util.List;

import com.sportsshop.model.Product;

/**
 * These Services are provided by sports shop application.
 */
public interface ShopServices {
	
    boolean addProduct(Product product);
    
    List<Product> selectAllProducts();
		
    Product selectProduct(Product product);
		
    boolean updateProductPrice(Product product);
		
    boolean removeProduct(Product product);
}

