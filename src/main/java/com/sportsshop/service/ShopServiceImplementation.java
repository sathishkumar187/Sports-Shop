package com.sportsshop.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sportsshop.customexceptions.CustomException.InvalidProductException;
import com.sportsshop.model.Product;

/**
 * Implements the services provided by the Shop application.
 */
public class ShopServiceImplementation implements ShopServices {
	
    private static final Map<String, List<Product>> SPORTS_KITS = new HashMap<String, List<Product>>();
	
    /**
     * Adds the product.
     */
    public void addProduct(final Product product) {
	final List<Product> sportsProducts = new ArrayList<Product>();
		
	    if (!SPORTS_KITS.containsKey(product.getBrand())) {
       	    sportsProducts.add(product);
  	        SPORTS_KITS.put(product.getBrand(), sportsProducts);
	    } else {
	        SPORTS_KITS.get(product.getBrand()).add(product);
	    }
    }    

    /**
     * Selects the product.
     */
    public Product selectProduct(final Product product) {
		
	    if (SPORTS_KITS.containsKey(product.getBrand())) {

            for (final Product productDetails : SPORTS_KITS.get(product.getBrand())) {

                if (productDetails.getBrand().equals(product.getBrand()) && productDetails.getName().equals(product.getName())
			            && productDetails.getSize() == product.getSize()) {
		            return productDetails;
	            }
            }
	    } 
        throw new InvalidProductException("Product Not In Crew");
    }

    /**
     * Update the product price.
     */
    public void updateProductPrice(final Product product) {
    final Product productDetails = selectProduct(product);
		
        if (productDetails != null) {
	        productDetails.setPrice(product.getPrice());
        } else {
	        throw new InvalidProductException("Product Not In Crew");
        }
    }    

    /**
     * Remove the product.  
     */
    public void removeProduct(final Product product) {
	    final Product productDetails = selectProduct(product);
		
	    if (productDetails == null) {
	        SPORTS_KITS.get(product.getBrand()).remove(productDetails);
	    } else {
	        throw new InvalidProductException("Product Not In Crew");
	    }
    }    
	
    /**
     * Select all the products.
     */
    public List<Product> selectAllProducts() {
        List<Product> allProducts = new ArrayList<>();
		
        for (final List<Product> products : SPORTS_KITS.values()) {
	        allProducts.addAll(products);
	    }
	    return allProducts;
    }
}
