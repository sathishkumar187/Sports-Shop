package com.sportsshop.view;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class Validations {

    static int validateOperation(String operation) {
		
        if (operation.matches("[1-5]")) {
            return Integer.parseInt(operation);
        } 
        else {
            System.out.println("Selected Operation Is Invalid \n Re-Enter Valid Operation(Use Only 1-5)");
            return validateOperation(SportsShop.SCANNER.nextLine());
        }
    }

    static String validateName(String name) {
		
        if (name.matches("Bat|Ball|Stump")) {
            return name;
        } 
        else {
            System.out.println("Product Is Not Available \n Select Anyone Of Them (Bat, Ball, Stump)");
            return validateName(SportsShop.SCANNER.next());
        }
    }

    static String validateBrand(String brandName) {
		
        if (brandName.matches("SS|SG|MRF|RBK|NIKE")) {
            return brandName;
        } 
        else {
            System.out.println("Brand Is Not Available \n Select Anyone Of Them (SS, SG, MRF, RBK, NIKE)");
            return validateBrand(SportsShop.SCANNER.next());
        }
    }

    static float validatePrice(String price) {
		
        if (price.matches("[+-]?([0-9]+([.][0-9]*)?|[.][0-9]+)")) {
            return Float.parseFloat(price);
        } 
        else {
            System.out.println("Price Is Invalid \n Re-Enter Valid Price(Use Whole Numbers and Decimal Numbers Only)");
            return validatePrice(SportsShop.SCANNER.next());
        }
    }

    static char validateSize(String size) {
		
        if (size.matches("S|M|L")) {
            return size.charAt(0);
        } 
        else {
            System.out.println("Size Is Invalid \n Re-Enter Valid Size(Use Only S, M, L)");
            return validateSize(SportsShop.SCANNER.next());
        }
    }
	
    static Date validateDate(String inputDate) {
		
        try {
            LocalDate date = LocalDate.parse(inputDate);
            LocalDate todayDate = LocalDate.now();

            if (todayDate.plusDays(1).isAfter(date)) {
                return Date.from(date.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
            } 
            else {
                System.out.println("Date Is Invalid \n Re-Enter Valid Date");
                return validateDate(SportsShop.SCANNER.next());
            }
        } catch(Exception e) {
            System.out.println("Date Is Invalid \n Re-Enter Valid Date");
            return validateDate(SportsShop.SCANNER.next());
        }
    }
}
