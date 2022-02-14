package com.sportsshop.view;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.sportsshop.controller.ShopKeeper;
import com.sportsshop.customexceptions.CustomException.InvalidProductException;
import com.sportsshop.customexceptions.CustomException.UnableToAccessException;
import com.sportsshop.model.Product;

/**
 * The shop application for sports-kits using CRUD operations - Create, Read, Update, Delete. 
 */
public class SportsShop  {
	
    public static final Scanner SCANNER = new Scanner(System.in);
    public static final Logger LOGGER = Logger.getLogger(SportsShop.class);
    
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
		final Properties properties = new Properties();
		
		properties.load(new FileInputStream("log4j.properties"));
		PropertyConfigurator.configure(properties);
		SportsShop.menu();
    }
    /**
     * Main menu.
     */
    static void menu() {
    	
    	do {
        	LOGGER.info("\n\n    <^_^> Sports Shop Application <^_^>\n\n Operations \n  1.Add Product \n  2.Select Product \n  3.Update Product Price \n  4.Remove Product \n  5.Select All Products \n  6.Exit \n\n Select Any Operation");
            final int operation = GetDetailsFromUser.getOperation();

            switch (operation) {
            case 1:
                SportsShop.addProduct();
                break;
            case 2:
                SportsShop.selectAnyProduct();
                break;
            case 3:
                SportsShop.updateProductPrice();
                break;
            case 4:
                SportsShop.removeProduct();
                break;
            case 5:
            	SportsShop.showAllProducts();
            	break;
            case 6:
                SCANNER.close();
                System.exit(0);
            }
        } while (true);
    }

    /**
     * Add the new product.  
     */
    private static void addProduct() {
        final Product product = new Product();
        final ShopKeeper shopKeeper = new ShopKeeper();
        
        product.setBrand(GetDetailsFromUser.getProductBrand());
        product.setName(GetDetailsFromUser.getProductName());
        product.setPrice(GetDetailsFromUser.getProductPrice());
        product.setSize(GetDetailsFromUser.getProductSize());
        product.setManufactureDate(GetDetailsFromUser.getManufacturingDate());

        try {
        	shopKeeper.addProduct(product);
        	LOGGER.info("\n Product Added Successfully");
        } catch (InvalidProductException exception) {
        	LOGGER.warn(exception);
        } catch (UnableToAccessException exception) {
        	LOGGER.error(exception);
        }
    }

    /**
     * Call the customer for select any product. 
     */
    private static void selectAnyProduct() {
    	LOGGER.info("\n Select Any Product");
        final Customer customer = new Customer();

        customer.selectProduct();
    }

    /**
     * Update the product price. 
     */
    private static void updateProductPrice() {
        final Product product = new Product();
        final ShopKeeper shopKeeper = new ShopKeeper();
        
        product.setBrand(GetDetailsFromUser.getProductBrand());
        product.setName(GetDetailsFromUser.getProductName());
        product.setSize(GetDetailsFromUser.getProductSize());
        
        try {
        	shopKeeper.selectProduct(product);
        } catch (InvalidProductException exception) {
        	LOGGER.warn(exception);
        	updateProductPrice();
        	menu();
        } catch (UnableToAccessException exception) {
        	LOGGER.error(exception);
        }
        product.setPrice(GetDetailsFromUser.getProductPrice());
        
        try {
            shopKeeper.updateProductPrice(product);
            LOGGER.info("\n Product Updated Successfully");
        } catch (InvalidProductException exception) {
        	LOGGER.warn(exception);
        } catch (UnableToAccessException exception) {
        	LOGGER.error(exception);
        }
    }

    /**
     * Remove the product.
     */
    private static void removeProduct() {
        final Product product = new Product();
        final ShopKeeper shopKeeper = new ShopKeeper();
        
        product.setBrand(GetDetailsFromUser.getProductBrand());
        product.setName(GetDetailsFromUser.getProductName());
        product.setSize(GetDetailsFromUser.getProductSize());

        try {
            shopKeeper.removeProduct(product);
            LOGGER.info("\n Product Removed Successfully");
        } catch (InvalidProductException exception) {
        	LOGGER.warn(exception);
        } catch (UnableToAccessException exception) {
        	LOGGER.error(exception);
        }
    }
    
    /**
     * Show all the available products.
     */
    private static void showAllProducts() {
    	final ShopKeeper shopKeeper = new ShopKeeper();
    	List<Product> products = null;
    	
    	try {
    		products = shopKeeper.selectAllProducts();
    	} catch (InvalidProductException exception) {
    		LOGGER.warn(exception);
        } catch (UnableToAccessException exception) {
        	LOGGER.error(exception);
        }
    	
        if (products != null) {

            for (Product product : products) {
            	LOGGER.info(String.format("%s %s %s %s %s %s %f %s %c %s %s", "\n\n ", product.getBrand(),
                    "Brand :", "\n  Product Name :", product.getName(), "\n   Product Price :", product.getPrice(),
                    "\n   Product Size :", product.getSize(), "\n   Manufacture Date :", product.getManufactureDate().toString()));
            }
        }
    }

    /**
     * Show the Selected Product.
     * @param product
     */
    public static void showProduct(final Product product) {

        if (product != null) {
        	LOGGER.info(String.format("%s %s %s %s %s %f %s %c %s %s","\n\n Product Details : \n  Product Name :",
                product.getName(), "\n  Product Brand :", product.getBrand(), "\n  Product Price :",
                product.getPrice(), "\n  Product Size :", product.getSize(), "\n  Manufacture Date :",
                product.getManufactureDate()).toString());
        }
    }
}
