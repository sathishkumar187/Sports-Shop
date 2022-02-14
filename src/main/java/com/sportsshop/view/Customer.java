package com.sportsshop.view;

import com.sportsshop.controller.ShopKeeper;
import com.sportsshop.customexceptions.CustomException.InvalidProductException;
import com.sportsshop.customexceptions.CustomException.UnableToAccessException;
import com.sportsshop.model.Product;

/**
 * Customer class of the sports shop.
 */
public class Customer {

    /**
     * Select the product.
     */
    void selectProduct() {
        final Product product = new Product();
        final ShopKeeper shopKeeper = new ShopKeeper();

        product.setBrand(GetDetailsFromUser.getProductBrand());
        product.setName(GetDetailsFromUser.getProductName());
        product.setSize(GetDetailsFromUser.getProductSize());
        
        try {
            SportsShop.showProduct(shopKeeper.selectProduct(product));
        } catch (InvalidProductException exception) {
        	SportsShop.LOGGER.warn(exception);
        } catch (UnableToAccessException exception) {
        	SportsShop.LOGGER.error(exception);
        }
    }
}
