package com.sportsshop.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sportsshop.model.Product;

/**
 * It implements the services provided by the Shop application.
 */
public class ShopServiceImplementation implements ShopServices {
	private static final Map<String, List<Product>> SPORTS_KITS = new HashMap<String, List<Product>>();
	
	/**
	 * It adds the product.
	 */
	public void addProduct(Product product) {
		final List<Product> sportsProducts = new ArrayList<Product>();
		
		if (!SPORTS_KITS.containsKey(product.getBrand())) {
			sportsProducts.add(product);
			SPORTS_KITS.put(product.getBrand(), sportsProducts);
		} else {
			SPORTS_KITS.get(product.getBrand()).add(product);
		}
	}

	/**
	 * It selects the product.
	 * @throws NullProductException 
	 */
	public Product selectProduct(Product product) throws InvalidProductException {
		
		if (SPORTS_KITS.containsKey(product.getBrand())) {

			for (Product productDetails : SPORTS_KITS.get(product.getBrand())) {

				if (productDetails.getBrand().equals(product.getBrand())
						&& productDetails.getName().equals(product.getName())
						&& productDetails.getSize() == product.getSize()) {
					return productDetails;
				}
			}
		} else {
			throw new InvalidProductException("Product Not In Crew");
		}
		return null;
	}

	/**
	 * To update the product price.
	 * @throws NullProductException 
	 */
	public Product updateProductPrice(Product product) throws InvalidProductException {
		final Product productDetails = selectProduct(product);
		
		if (productDetails != null) {
			productDetails.setPrice(product.getPrice());
			return productDetails;
		} else {
			throw new InvalidProductException("Product Not In Crew");
		}
	}

	/**
	 * To remove the product.
	 * @throws InvalidProductException 
	 */
	public Product removeProduct(Product product) throws InvalidProductException {
		final Product productDetails = selectProduct(product);
		
		if (productDetails == null) {
			SPORTS_KITS.get(product.getBrand()).remove(productDetails);
			return productDetails;
		} else {
			throw new InvalidProductException("Product Not In Crew");
		}
	}
	
	/**
	 * Select all the products.
	 */
	public List<Product> selectAllProducts() {
		List<Product> allProducts = new ArrayList<>();
		
		for (List<Product> products : SPORTS_KITS.values()) {
			allProducts.addAll(products);
		}
		
		return allProducts;
	}
}
