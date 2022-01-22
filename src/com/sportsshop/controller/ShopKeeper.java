package com.sportsshop.controller;

import com.sportsshop.model.Product;
import com.sportsshop.service.ShopServiceImplementation;
import com.sportsshop.service.ShopServices;
import com.sportsshop.view.SportsShop;

public class ShopKeeper  {
	private static final ShopServices SHOP_SERVICE_IMPLEMENTATION = new ShopServiceImplementation();
	
	public static void addProduct(String brand, Product product) {
		SportsShop.showAllProducts(SHOP_SERVICE_IMPLEMENTATION.addProduct(brand, product));
	}

	public static void selectProduct(String brand, String name, char size) {
		SportsShop.showSelectedProduct(SHOP_SERVICE_IMPLEMENTATION.selectProduct(brand, name, size));
	}

	public static void updateProductPrice(String brand, String name, char size, float price) {
		SportsShop.showAllProducts(SHOP_SERVICE_IMPLEMENTATION.updateProductPrice(brand, name, size, price));
	}

	public static void removeProduct(String brand, String name, char size) {
		SportsShop.showAllProducts(SHOP_SERVICE_IMPLEMENTATION.removeProduct(brand, name, size));
	}
	
}
