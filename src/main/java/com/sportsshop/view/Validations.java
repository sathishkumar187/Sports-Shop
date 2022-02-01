package com.sportsshop.view;

import java.sql.Date;
import java.time.LocalDate;

/**
 * To validate the user inputed data.
 */
public class Validations {

    /**
     * It validates the selected operation.
     * @param operation
     * @return validated operation by int.
     */
    static int validateOperation(String operation) {
		
        if (operation.matches("[1-6]")) {
            return Integer.parseInt(operation);
        } else {
            System.out.println("Selected Operation Is Invalid \n Re-Enter Valid Operation(Use Only 1-6)");
            return validateOperation(SportsShop.SCANNER.next());
        }
    }

    /**
     * It validates the product name.
     * @param name
     * @return validated name by String.
     */
    static String validateName(String name) {
		
        if (name.matches("(?i)[bat|ball|stump|gloves|helmet].*(?-i)")) {
            return name;
        } else {
            System.out.println("Product Is Not Available \n Select Anyone Of Them (Bat, Ball, Stump)");
            return validateName(SportsShop.SCANNER.next());
        }
    }

     /**
     * It validates the product brand.
     * @param brandName
     * @return validated brand name by String.
     */
    static String validateBrand(String brandName) {
		
        if (brandName.matches("(?i)[ss|sg|mrf|nike|rbk].*(?-i)")) {
            return brandName;
        } else {
            System.out.println("Brand Is Not Available \n Select Anyone Of Them (SS, SG, MRF, RBK, NIKE)");
            return validateBrand(SportsShop.SCANNER.next());
        }
    }

     /**
     * It validates the product price.
     * @param price
     * @return validated price by float.
     */
    static double validatePrice(String price) {
		
        if (price.matches("[+-]?([0-9]+([.][0-9]*)?|[.][0-9]+)")) {
            return Double.parseDouble(price);
        } else {
            System.out.println("Price Is Invalid \n Re-Enter Valid Price(Use Whole Numbers and Decimal Numbers Only)");
            return validatePrice(SportsShop.SCANNER.next());
        }
    }

     /**
     * It validates the product size.
     * @param size
     * @return validated size by char.
     */
    static char validateSize(String size) {
		
        if (size.matches("(?i)[s|m|l].*(?-i)")) {
            return size.charAt(0);
        } else {
            System.out.println("Size Is Invalid \n Re-Enter Valid Size(Use Only S, M, L)");
            return validateSize(SportsShop.SCANNER.next());
        }
    }

	/**
     * It validates the manufacture date of product.
     * @param inputDate
     * @return validated manufacture date by Date
     */
    static Date validateDate(String inputDate) {
		
        try {
            final LocalDate date = LocalDate.parse(inputDate);
            final LocalDate todayDate = LocalDate.now();
            
            if (todayDate.plusDays(1).isAfter(date)) {
                return Date.valueOf(date);
            } else {
                System.out.println("Date Is Invalid \n Re-Enter Valid Date");
                return validateDate(SportsShop.SCANNER.next());
            }
        } catch(Exception e) {
            System.out.println("Date Is Invalid \n Re-Enter Valid Date");
            return validateDate(SportsShop.SCANNER.next());
        }
    }
}
