package com.sportsshop.view;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.sportsshop.controller.ShopKeeper;
import com.sportsshop.model.Product;

public class SportsShop  {
    public static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        int operation;
		
        do {
            System.out.println("\n Operations \n  1.Add Product \n  2.Select Product \n  3.Update Product Price \n  4.Remove Product \n  5.Exit \n   Select Any Operation");
            operation = Validations.validateOperation(SCANNER.next());

            switch (operation) {
            case 1:
                SportsShop.addProduct();
                break;
            case 2:
                SportsShop.selectProduct();
                break;
            case 3:
                SportsShop.updateProductPrice();
                break;
            case 4:
                SportsShop.removeProduct();
                break;
            case 5:
                SCANNER.close();
                System.exit(0);
            }
        } while (true);
    }

    private static final void addProduct() {
        final Product product = new Product();

        System.out.println("Mention Product Brand(SS, SG, MRF, RBK, NIKE)");
        product.setBrand(Validations.validateBrand(SCANNER.next()));

        System.out.println("Mention Product Name(Bat, Ball, Stump)");
        product.setName(Validations.validateName(SCANNER.next()));

        System.out.println("Mention Product Price");
        product.setPrice(Validations.validatePrice(SCANNER.next()));

        System.out.println("Mention Product Size(S, M, L)");
        product.setSize(Validations.validateSize(SCANNER.next()));

        System.out.println("Mention Manufacture Date(YYYY-MM-DD)");
        product.setManufactureDate(Validations.validateDate(SCANNER.next()));

        ShopKeeper.addProduct(product.getBrand(), product);
    }

    private static final void selectProduct() {
        System.out.println("Select Any Product");
        Customer customer = new Customer();

        customer.selectAnyProduct();
    }

    private static final void updateProductPrice() {
        System.out.println("Mention Product Brand(SS, SG, MRF, RBK, NIKE)");
        String brand = Validations.validateBrand(SCANNER.next());

        System.out.println("Mention Product Name(Bat, Ball, Stump)");
        String name = Validations.validateName(SCANNER.next());

        System.out.println("Mention Product Size(S, M, L)");
        char size = Validations.validateSize(SCANNER.next());

        System.out.println("Mention Product Price");
        float price = Validations.validatePrice(SCANNER.next());

        ShopKeeper.updateProductPrice(brand, name, size, price);
    }

    private static final void removeProduct() {
        System.out.println("Mention Product Brand(SS, SG, MRF, RBK, NIKE)");
        String brand = Validations.validateBrand(SCANNER.next());

        System.out.println("Mention Product Name(Bat, Ball, Stump)");
        String name = Validations.validateName(SCANNER.next());

        System.out.println("Mention Product Size(S, M, L)");
        char size = Validations.validateSize(SCANNER.next());

        ShopKeeper.removeProduct(brand, name, size);
    }

    public static final void showAllProducts(Map<String, List<Product>> sportsKits) {

        if (sportsKits != null) {

            for (String productBrand : sportsKits.keySet()) {
                System.out.println(new StringBuilder().append("\n ").append(productBrand).append(" Brand :"));

                for (Product product : sportsKits.get(productBrand)) {

                    if (product.getBrand().equals(productBrand)) {
                        System.out.println(new StringBuilder().append("\n { Product Name : ").append(product.getName()).append("\n   Product Price : ")
                            .append(product.getPrice()).append("\n   Product Size : ").append(product.getSize())
                            .append("\n   Manufacture Date : ").append(product.getManufactureDate()).append(" }").toString());
                    }
                }
            }
        }
        else {
            System.out.println("\n  Product Not In Crew");
        }
    }

    public static final void showSelectedProduct(Product product) {

        if (product != null) {
            System.out.println(new StringBuilder().append("\n Product Details : \n  Product Name : ").append(product.getName())
                .append("\n  Product Brand : ").append(product.getBrand()).append("\n  Product Price : ")
                .append(product.getPrice()).append("\n  Product Size : ").append(product.getSize())
                .append("\n  Manufacture Date : ").append(product.getManufactureDate()).toString());
        }
        else {
            System.out.println("\n  Product Not In Crew");
        }
    }
}
