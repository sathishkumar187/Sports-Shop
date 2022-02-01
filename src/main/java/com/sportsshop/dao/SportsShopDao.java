package com.sportsshop.dao;

import java.util.List;

import com.sportsshop.model.Product;

/**
 * Data Access Object. 
 * @author SathishKumarS
 *
 */
public interface SportsShopDao {

	void addProduct(Product product);
	
	void updateProductPrice(Product product);
	
	void removeProduct(Product product);
	
	List<Product> selectAllProducts();
}
