package com.sportsshop.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sportsshop.model.Product;

public class ShopServiceImplementation implements ShopServices {
    private static final Map<String, List<Product>> SPORTS_KITS = new HashMap<>();
    private static final List<Product> SPORTS_PRODUCTS = new ArrayList<>();

    public Map<String, List<Product>> addProduct(String brand, Product product) {

	if (!SPORTS_KITS.containsKey(brand)) {
            SPORTS_PRODUCTS.add(product);
	    SPORTS_KITS.put(brand, SPORTS_PRODUCTS);
	} 
	else {
	    SPORTS_PRODUCTS.add(product);
	}
	return SPORTS_KITS;
    }

    public Product selectProduct(String brand, String name, char size) {

	if (SPORTS_KITS.containsKey(brand)) {
            List<Product> products = SPORTS_KITS.get(brand);

	    for (Product product : products) {

	        if (product.getBrand().equals(brand) && product.getName().equals(name) && product.getSize() == size) {
	       	    return SPORTS_PRODUCTS.get(SPORTS_PRODUCTS.indexOf(product));
		}
	    }
	}
	return null;
    }

    public Map<String, List<Product>> updateProductPrice(String brand, String name, char size, float price) {
        Product product = selectProduct(brand, name, size);

	if (product != null){
	    product.setPrice(price);
	    return SPORTS_KITS;
	}
	return null;
    }

    public Map<String, List<Product>> removeProduct(String brand, String name, char size) {
	Product product = selectProduct(brand, name, size);
	    
	if (product != null){
	    SPORTS_PRODUCTS.remove(product);
	    return SPORTS_KITS;
	}
	return null;
    }
}
