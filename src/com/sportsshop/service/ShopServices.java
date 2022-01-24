package com.sportsshop.service;

import java.util.List;
import java.util.Map;

import com.sportsshop.model.Product;
/**
 * These Services are provided by sports shop application.
 */
public interface ShopServices {
	
    Map<String, List<Product>> addProduct(String productBrand, Product product);
		
    Product selectProduct(String brand, String name, char size);
		
    Map<String, List<Product>> updateProductPrice(String brand, String name, char size, float price);
		
    Map<String, List<Product>> removeProduct(String brand, String name, char size);
}

