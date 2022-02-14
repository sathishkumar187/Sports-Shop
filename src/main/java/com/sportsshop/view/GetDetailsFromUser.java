package com.sportsshop.view;

import java.sql.Date;

import com.sportsshop.customexceptions.CustomException.InvalidDateException;
/**
 * To get input.
 * @author SathishKumarS
 *
 */
public class GetDetailsFromUser {

	static int getOperation() {
		final String operation = SportsShop.SCANNER.next().trim();
		final boolean isValidated = Validations.validateOperation(operation);

		if (isValidated) {
			return Integer.parseInt(operation);
		} else {
			SportsShop.LOGGER.info("\n Selected Operation Is Invalid \n  Re-Enter Valid Operation(Use Only 1-6)");
			return getOperation();
		}
	}

	static String getProductName() {
		SportsShop.LOGGER.info("\n Mention Product Name(Bat, Ball, Stump, Gloves, Helmet) ^^^ If You Want To Go Back To Main Menu, Press # ^^^");
		final String name = SportsShop.SCANNER.next().trim();
		
		GetDetailsFromUser.backToMenu(name);
		final boolean isValidated = Validations.validateName(name);

		if (isValidated) {
			return name.toUpperCase();
		} else {
			SportsShop.LOGGER.info("\n Product Is Not Available \n  Select Anyone Of Them (Bat, Ball, Stump, Gloves, Helmet) ^^^ If You Want To Go Back To Main Menu, Press # ^^^");
			return getProductName();
		}
	}

	static String getProductBrand() {
		SportsShop.LOGGER.info("\n Mention Product Brand(SS, SG, MRF, RBK, NIKE) ^^^ If You Want To Go Back To Main Menu, Press # ^^^");
		final String brand = SportsShop.SCANNER.next().trim();
		
		GetDetailsFromUser.backToMenu(brand);
		final boolean isValidated = Validations.validateBrand(brand);

		if (isValidated) {
			return brand.toUpperCase();
		} else {
			SportsShop.LOGGER.info("/n Brand Is Not Available \n  Select Anyone Of Them (SS, SG, MRF, RBK, NIKE) ^^^ If You Want To Go Back To Main Menu, Press # ^^^");
			return getProductBrand();
		}
	}

	static double getProductPrice() {
		SportsShop.LOGGER.info("\n Mention Product Price ^^^ If You Want To Go Back To Main Menu, Press # ^^^");
		final String price = SportsShop.SCANNER.next().trim();
		
		GetDetailsFromUser.backToMenu(price);
		final boolean isValidated = Validations.validatePrice(price);

		if (isValidated) {
			return Double.parseDouble(price);
		} else {
			SportsShop.LOGGER.info("/n Price Is Invalid \n  Re-Enter Valid Price(Use Whole Numbers and Decimal Numbers Only) ^^^ If You Want To Go Back To Main Menu, Press # ^^^");
			return getProductPrice();
		}
	}

	static char getProductSize() {
		SportsShop.LOGGER.info("\n Mention Product Size(S, M, L) ^^^ If You Want To Go Back To Main Menu, Press # ^^^");
		final String size = SportsShop.SCANNER.next().trim();
		
		GetDetailsFromUser.backToMenu(size);
		final boolean isValidated = Validations.validateSize(size);

		if (isValidated) {
			return size.toUpperCase().charAt(0);
		} else {
			SportsShop.LOGGER.info("\n Size Is Invalid \n  Re-Enter Valid Size(Use Only S, M, L) ^^^ If You Want To Go Back To Main Menu, Press # ^^^");
			return getProductSize();
		}
	}

	static Date getManufacturingDate() {
		SportsShop.LOGGER.info("\n Mention Manufacture Date(YYYY-MM-DD) ^^^ If You Want To Go Back To Main Menu, Press # ^^^");
		final String manufacturingDate = SportsShop.SCANNER.next().trim();
		
		GetDetailsFromUser.backToMenu(manufacturingDate);
		
        try {
        	boolean isValidated = Validations.validateDate(manufacturingDate); 

		    if (isValidated) {
			    return Date.valueOf(manufacturingDate);
		    } else {
		    	SportsShop.LOGGER.info("\n Date Is Invalid \n  Re-Enter Valid Date ^^^ If You Want To Go Back To Main Menu, Press # ^^^");			
			    return getManufacturingDate();
		    }
        } catch (InvalidDateException exception) {
        	SportsShop.LOGGER.warn(exception);
        }
		return getManufacturingDate();
	}
	
	private static void backToMenu(final String userInput) {
		
		if ("#".equals(userInput)) {
			SportsShop.menu();
		}
	}
}
