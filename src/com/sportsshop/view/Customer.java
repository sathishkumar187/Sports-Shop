package com.sportsshop.view;

import com.sportsshop.controller.ShopKeeper;

public class Customer {

	void selectAnyProduct() {
		System.out.println("Mention Product Brand(SS, SG, MRF, RBK, NIKE)");
		String brand = Validations.validateBrand(SportsShop.SCANNER.next());
		
		System.out.println("Mention Product Name(Bat, Ball, Stump)");
		String name = Validations.validateName(SportsShop.SCANNER.next());
		
		System.out.println("Mention Product Size(S, M, L)");
		char size = Validations.validateSize(SportsShop.SCANNER.next());
		
		ShopKeeper.selectProduct(brand, name, size);	
	}
}
