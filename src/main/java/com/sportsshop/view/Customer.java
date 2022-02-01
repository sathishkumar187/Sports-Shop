package com.sportsshop.view;

import com.sportsshop.controller.ShopKeeper;
import com.sportsshop.model.Product;
import com.sportsshop.service.InvalidProductException;

/**
 * Customer class of the sports shop.
 */
public class Customer {

    /**
     * To select the product.
     * @throws InvalidProductException 
     */
    void selectProduct() throws InvalidProductException {
        final Product product = new Product();
        final ShopKeeper shopKeeper = new ShopKeeper();

        System.out.println("Mention Product Brand(SS, SG, MRF, RBK, NIKE)");
        product.setBrand(Validations.validateBrand(SportsShop.SCANNER.next()));
		
        System.out.println("Mention Product Name(Bat, Ball, Stump, Gloves, Helmet)");
        product.setName(Validations.validateName(SportsShop.SCANNER.next()));
		
        System.out.println("Mention Product Size(S, M, L)");
        product.setSize(Validations.validateSize(SportsShop.SCANNER.next()));
		
        shopKeeper.selectProduct(product);	
    }
}
