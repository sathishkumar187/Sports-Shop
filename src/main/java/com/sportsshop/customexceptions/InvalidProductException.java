package com.sportsshop.customexceptions;

public class InvalidProductException extends RuntimeException {
	
    public InvalidProductException(String message) {
        super(message);
    }
}
