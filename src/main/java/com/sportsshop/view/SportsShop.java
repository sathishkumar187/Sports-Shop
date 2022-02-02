package com.sportsshop.view;

import java.util.List;
import java.util.Scanner;

import com.sportsshop.controller.ShopKeeper;
import com.sportsshop.customexceptions.InvalidProductException;
import com.sportsshop.model.Product;

/**
 * The shop application for sports-kits using CRUD operations - Create, Read, Update, Delete. 
 */
public class SportsShop  {
    public static final Scanner SCANNER = new Scanner(System.in);
    
    public static void main(String[] args) {
		
        do {
            System.out.println("\n Operations \n  1.Add Product \n  2.Select Product \n  3.Update Product Price \n  4.Remove Product \n  5.Select All Products \n  6.Exit \n   Select Any Operation");
            final int operation = Validations.validateOperation(SCANNER.next());

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
     * To add the new product.  
     */
    private static final void addProduct() {
        final Product product = new Product();
        final ShopKeeper shopKeeper = new ShopKeeper();
        
        System.out.println("Mention Product Brand(SS, SG, MRF, RBK, NIKE)");
        product.setBrand(Validations.validateBrand(SCANNER.next()));

        System.out.println("Mention Product Name(Bat, Ball, Stump, Gloves, Helmet)");
        product.setName(Validations.validateName(SCANNER.next()));

        System.out.println("Mention Product Price");
        product.setPrice(Validations.validatePrice(SCANNER.next()));

        System.out.println("Mention Product Size(S, M, L)");
        product.setSize(Validations.validateSize(SCANNER.next()));

        System.out.println("Mention Manufacture Date(YYYY-MM-DD)");
        product.setManufactureDate(Validations.validateDate(SCANNER.next()));

        shopKeeper.addProduct(product);
    }

    /**
     * To call the customer for select any product. 
     * @throws InvalidProductException 
     */
    private static final void selectAnyProduct() {
        System.out.println("Select Any Product");
        Customer customer = new Customer();

        customer.selectProduct();
    }

    /**
     * To update the product price. 
     */
    private static final void updateProductPrice() {
        final Product product = new Product();
        final ShopKeeper shopKeeper = new ShopKeeper();
        
        System.out.println("Mention Product Brand(SS, SG, MRF, RBK, NIKE)");
        product.setBrand(Validations.validateBrand(SCANNER.next()));

        System.out.println("Mention Product Name(Bat, Ball, Stump, Gloves, Helmet)");
        product.setName(Validations.validateName(SCANNER.next()));

        System.out.println("Mention Product Size(S, M, L)");
        product.setSize(Validations.validateSize(SCANNER.next()));

        System.out.println("Mention Product Price");
        product.setPrice(Validations.validatePrice(SCANNER.next()));
        
        try {
            shopKeeper.updateProductPrice(product);
        } catch (InvalidProductException exception) {
            System.out.println(exception);
        }
    }

    /**
     * To remove the product.
     */
    private static final void removeProduct() {
        final Product product = new Product();
        final ShopKeeper shopKeeper = new ShopKeeper();
        
        System.out.println("Mention Product Brand(SS, SG, MRF, RBK, NIKE)");
        product.setBrand(Validations.validateBrand(SCANNER.next()));

        System.out.println("Mention Product Name(Bat, Ball, Stump, Gloves, Helmet)");
        product.setName(Validations.validateName(SCANNER.next()));

        System.out.println("Mention Product Size(S, M, L)");
        product.setSize(Validations.validateSize(SCANNER.next()));

        try {
            shopKeeper.removeProduct(product);
    	} catch (InvalidProductException exception) {
            System.out.println(exception);
    	}
    }
    
    /**
     * To show all the available products.
     * @param sportsKits
     */
    public static final void showAllProducts() {
    	final ShopKeeper shopKeeper = new ShopKeeper();
    	List<Product> products = shopKeeper.selectAllProducts();
    	
        if (products != null) {

            for (Product product : products) {
                System.out.println(String.format("%s %s %s %s %s %s %f %s %c %s %s %s", "\n ", product.getBrand(),
                    "Brand :", "\n { Product Name :", product.getName(), "\n   Product Price :", product.getPrice(),
                    "\n   Product Size :", product.getSize(), "\n   Manufacture Date :", product.getManufactureDate().toString(), " }"));
            }
        }
    }

    /**
     * To show the Selected Product.
     * @param product
     */
    public static final void showProduct(Product product) {

        if (product != null) {
            System.out.println(String.format("%s %s %s %s %s %f %s %c %s %s","\n Product Details : \n  Product Name :",
                product.getName(), "\n  Product Brand :", product.getBrand(), "\n  Product Price :",
                product.getPrice(), "\n  Product Size :", product.getSize(), "\n  Manufacture Date :",
                product.getManufactureDate()).toString());
        }
    }
}
