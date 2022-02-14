package com.sportsshop.service;

import java.util.List;

import com.sportsshop.customexceptions.CustomException.InvalidProductException;
import com.sportsshop.dao.SportsShopDao;
import com.sportsshop.dao.SportsShopDaoImp;
import com.sportsshop.model.Product;

/**
 * Implements ShopServiceDao.
 * @author SathishKumarS
 *
 */
public class ShopServiceImplementationV2 implements ShopServices {
	
    private static final SportsShopDao SPORTS_SHOP_DAO = new SportsShopDaoImp();

    public void addProduct(final Product product) {
    	SPORTS_SHOP_DAO.addProduct(product);
    }

    public List<Product> selectAllProducts() {
    	final List<Product> products = SPORTS_SHOP_DAO.selectAllProducts();
    	
        if (!products.isEmpty()) {
            return products;
        }
        throw new InvalidProductException("No Such Products In Crew");
    }

    public void updateProductPrice(final Product product) {
    	
    	if (!SPORTS_SHOP_DAO.updateProductPrice(product)) {
            throw new InvalidProductException("Product Not In Crew");
    	}
    }

    public void removeProduct(final Product product) { 
    	
    	if (!SPORTS_SHOP_DAO.removeProduct(product)) {
            throw new InvalidProductException("Product Not In Crew");
    	}
    }
	
    public Product selectProduct(final Product product) {
		
	for (final Product productDetails : SPORTS_SHOP_DAO.selectAllProducts()) {
	    	
	    if (productDetails.getBrand().equals(product.getBrand()) && productDetails.getName().equals(product.getName())
		        && String.valueOf(productDetails.getSize()).charAt(0) == product.getSize()) {
	        return productDetails;
	    } 
	}
        throw new InvalidProductException("Product Not In Crew");      
    }
}
