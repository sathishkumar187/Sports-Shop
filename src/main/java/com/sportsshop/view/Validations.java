package com.sportsshop.view;

import java.time.LocalDate;

import com.sportsshop.customexceptions.CustomException.InvalidDateException;;

/**
 * Validate the user inputed data.
 */
public class Validations {

    /**
     * Validates the selected operation.
     * @param operation
     * @return 
     */
    static boolean validateOperation(final String operation) {
		
        if (operation.matches("[1-6]")) {
            return true;
        } 
        return false;
    }

    /**
     * Validates the product name.
     * @param name
     * @return 
     */
    static boolean validateName(final String name) {
		
        if (name.matches("(?i).*-|bat|ball|stump|gloves|helmet|-.*")) {
            return true;
        } 
        return false;
    }

     /**
     * Validates the product brand.
     * @param brandName
     * @return
     */
    static boolean validateBrand(final String brandName) {
		
        if (brandName.matches("(?i).*-|ss|sg|mrf|nike|-.*")) {
            return true;
        } 
        return false;
    }

     /**
     * Validates the product price.
     * @param price
     * @return
     */
    static boolean validatePrice(final String price) {
		
        if (price.matches("[+-]?([0-9]+([.][0-9]*)?|[.][0-9]+)")) {
            return true;
        } 
        return false;
    }

     /**
     * Validates the product size.
     * @param size
     * @return
     */
    static boolean validateSize(final String size) {
		
        if (size.matches("(?i).*-|s|m|l|-.*")) {
            return true;
        } 
        return false;
    }

	/**
     * Validates the manufacture date of product.
     * @param inputDate
     * @return 
     */
    static boolean validateDate(final String inputDate) {
		
        try {
            final LocalDate date = LocalDate.parse(inputDate);
            final LocalDate todayDate = LocalDate.now();
            
            if (todayDate.plusDays(1).isAfter(date)) {
                return true;
            }
            return false;
        } catch(Exception e) {
            throw new InvalidDateException("Date Format Is Invalid \n Re-Enter Valid Date");
        }
    }
}
