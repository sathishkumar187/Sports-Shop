package com.sportsshop.controller;

import java.util.List;

import com.sportsshop.model.Product;
import com.sportsshop.service.ShopServiceImplementation;
import com.sportsshop.service.ShopServiceImplementationV2;
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
    
    public boolean addProduct(final Product product) {
    	//SHOP_SERVICE_IMPLEMENTATION.addProduct(product);
    	return SHOP_SERVICE_IMPLEMENTATION_V2.addProduct(product);
    }

    public Product selectProduct(final Product product) {
        //SportsShop.showProduct(SHOP_SERVICE_IMPLEMENTATION.selectProduct(product));
        return SHOP_SERVICE_IMPLEMENTATION_V2.selectProduct(product);
    }

    public boolean updateProductPrice(final Product product) {
        //SHOP_SERVICE_IMPLEMENTATION.updateProductPrice(product));
        return SHOP_SERVICE_IMPLEMENTATION_V2.updateProductPrice(product);
    }

    public boolean removeProduct(final Product product) {
        //SportsShop.showProduct(SHOP_SERVICE_IMPLEMENTATION.removeProduct(product));
        return SHOP_SERVICE_IMPLEMENTATION_V2.removeProduct(product);
    }

    public List<Product> selectAllProducts() {
    	//SHOP_SERVICE_IMPLEMENTATION.selectAllProducts();
        return SHOP_SERVICE_IMPLEMENTATION_V2.selectAllProducts();
    }
}
