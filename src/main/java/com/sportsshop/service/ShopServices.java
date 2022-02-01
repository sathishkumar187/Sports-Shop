package com.sportsshop.service;

import java.util.List;

import com.sportsshop.model.Product;

/**
 * These Services are provided by sports shop application.
 */
public interface ShopServices {
	
    void addProduct(Product product);
    
    List<Product> selectAllProducts();
		
    Product selectProduct(Product product) throws InvalidProductException;
		
    Product updateProductPrice(Product product) throws InvalidProductException;
		
    Product removeProduct(Product product) throws InvalidProductException;
}

