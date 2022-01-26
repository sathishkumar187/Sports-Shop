package com.sportsshop.controller;

import com.sportsshop.model.Product;
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
	
    public static void addProduct(Product product) {
        SportsShop.showAllProducts(SHOP_SERVICE_IMPLEMENTATION.addProduct(product));
    }

    public static void selectProduct(Product product) {
		SportsShop.showSelectedProduct(SHOP_SERVICE_IMPLEMENTATION.selectProduct(product));
    }

    public static void updateProductPrice(Product product) {
        SportsShop.showAllProducts(SHOP_SERVICE_IMPLEMENTATION.updateProductPrice(product));
    }

    public static void removeProduct(Product product) {
        SportsShop.showAllProducts(SHOP_SERVICE_IMPLEMENTATION.removeProduct(product));
    }
}
