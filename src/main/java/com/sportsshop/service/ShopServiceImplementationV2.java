package com.sportsshop.service;

import java.util.List;

import com.sportsshop.customexceptions.CustomException.InvalidProductException;
import com.sportsshop.dao.SportsShopDao;
import com.sportsshop.dao.SportsShopDaoImp;
import com.sportsshop.model.Product;

/**
 * It implements ShopServiceDao.
 * @author SathishKumarS
 *
 */
public class ShopServiceImplementationV2 implements ShopServices {
    private static final SportsShopDao SPORTS_SHOP_DAO = new SportsShopDaoImp();

    public boolean addProduct(final Product product) {
        final boolean isAdded = SPORTS_SHOP_DAO.addProduct(product);
        
        if (isAdded) {
        	return true;
        }
        throw new InvalidProductException("Product Not In Crew");
    }

    public List<Product> selectAllProducts() {
    	final List<Product> products = SPORTS_SHOP_DAO.selectAllProducts();
    	
        if (!products.isEmpty()) {
        	return products;
        }
        throw new InvalidProductException("Product Not In Crew");
    }

    public boolean updateProductPrice(final Product product) {
    	final boolean isUpdated = SPORTS_SHOP_DAO.updateProductPrice(product);
    	
    	if (isUpdated) {
    		return true;
    	}
    	throw new InvalidProductException("Product Not In Crew");
    }

    public boolean removeProduct(final Product product) {
    	final boolean isRemoved = SPORTS_SHOP_DAO.removeProduct(product);
    	
    	if (isRemoved) {
            return true;
    	}
        throw new InvalidProductException("Product Not In Crew");
    }
	
    public Product selectProduct(final Product product) {
		
	    for (final Product productDetails : SPORTS_SHOP_DAO.selectAllProducts()) {
			
	        if (productDetails.getBrand().equals(product.getBrand()) && productDetails.getName().equals(product.getName())
		            && productDetails.getSize() == product.getSize()) {
	            return productDetails;
	        } 
	    }
        throw new InvalidProductException("Product Not In Crew");      
    }
}
