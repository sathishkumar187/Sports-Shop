package com.sportsshop.controller;

import java.util.List;

import com.sportsshop.customexceptions.CustomException.InvalidProductException;
import com.sportsshop.model.Product;
import com.sportsshop.service.ShopServiceImplementationV2;
import com.sportsshop.service.ShopServiceImplementation;
import com.sportsshop.service.ShopServices;
import com.sportsshop.view.SportsShop;

/**
 * It controls and manage the requests and responses
 * It passes the requested data to implementation.
 * And also passes the response to view. 
 */
public class ShopKeeper  {
    private static final ShopServices SHOP_SERVICE_IMPLEMENTATION = new ShopServiceImplementation();
    private static final ShopServices SHOP_SERVICE_IMPLEMENTATION_V2 = new ShopServiceImplementationV2();
    
    public void addProduct(Product product) {
    	SHOP_SERVICE_IMPLEMENTATION.addProduct(product);
    	SHOP_SERVICE_IMPLEMENTATION_V2.addProduct(product);
    }

    public void selectProduct(Product product) throws InvalidProductException {
	SportsShop.showProduct(SHOP_SERVICE_IMPLEMENTATION.selectProduct(product));
	SportsShop.showProduct(SHOP_SERVICE_IMPLEMENTATION_V2.selectProduct(product));
    }

    public void updateProductPrice(Product product) throws InvalidProductException {
        SportsShop.showProduct(SHOP_SERVICE_IMPLEMENTATION.updateProductPrice(product));
        SportsShop.showProduct(SHOP_SERVICE_IMPLEMENTATION_V2.updateProductPrice(product));
    }

    public void removeProduct(Product product) throws InvalidProductException {
        SportsShop.showProduct(SHOP_SERVICE_IMPLEMENTATION.removeProduct(product));
        SportsShop.showProduct(SHOP_SERVICE_IMPLEMENTATION_V2.removeProduct(product));
    }

    public List<Product> selectAllProducts() {
	return SHOP_SERVICE_IMPLEMENTATION_V2.selectAllProducts();
    }
}
