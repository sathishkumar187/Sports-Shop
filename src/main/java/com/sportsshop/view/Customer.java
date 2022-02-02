package com.sportsshop.view;

import com.sportsshop.controller.ShopKeeper;
import com.sportsshop.customexceptions.InvalidProductException;
import com.sportsshop.model.Product;

/**
 * Customer class of the sports shop.
 */
public class Customer {

    /**
     * To select the product.
     * @throws InvalidProductException 
     */
    void selectProduct() {
        final Product product = new Product();
        final ShopKeeper shopKeeper = new ShopKeeper();

        System.out.println("\nMention Product Brand(SS, SG, MRF, RBK, NIKE)");
        product.setBrand(Validations.validateBrand(SportsShop.SCANNER.next()));
		
        System.out.println("Mention Product Name(Bat, Ball, Stump, Gloves, Helmet)");
        product.setName(Validations.validateName(SportsShop.SCANNER.next()));
		
        System.out.println("Mention Product Size(S, M, L)");
        product.setSize(Validations.validateSize(SportsShop.SCANNER.next()));
        
        try {
            shopKeeper.selectProduct(product);
        } catch (InvalidProductException exception) {
            System.out.println("Product Not In Crew");
        }
    }
}
