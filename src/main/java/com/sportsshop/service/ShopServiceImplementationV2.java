package com.sportsshop.service;

import java.util.List;

import com.sportsshop.dao.SportsShopDaoImp;
import com.sportsshop.model.Product;

/**
 * It implements ShopServiceDao.
 * @author SathishKumarS
 *
 */
public class ShopServiceImplementationV2 implements ShopServices {
	private static final SportsShopDaoImp SPORTS_SHOP_DAO = new SportsShopDaoImp();

	public void addProduct(Product product) {
		SPORTS_SHOP_DAO.addProduct(product);
	}

	public List<Product> selectAllProducts() {
		return SPORTS_SHOP_DAO.selectAllProducts();
	}

	public Product updateProductPrice(Product product) {
		SPORTS_SHOP_DAO.updateProductPrice(product);
		return selectProduct(product);
	}

	public Product removeProduct(Product product) {
		SPORTS_SHOP_DAO.removeProduct(product);
		return selectProduct(product);
	}
	
	public Product selectProduct(Product product) {
		
		for (Product productDetails : SPORTS_SHOP_DAO.selectAllProducts()) {
			
			if (productDetails.getBrand().equals(product.getBrand())
					&& productDetails.getName().equals(product.getName())
					&& productDetails.getSize() == product.getSize()) {
				return productDetails;
			} 
		}
		return null;
	}
}