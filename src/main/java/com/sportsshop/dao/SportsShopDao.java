package com.sportsshop.dao;

import java.util.List;

import com.sportsshop.model.Product;

/**
 * Data Access Object. 
 * @author SathishKumarS
 *
 */
public interface SportsShopDao {

    boolean addProduct(Product product);
	
    boolean updateProductPrice(Product product);
	
    boolean removeProduct(Product product);
	
    List<Product> selectAllProducts();
}
