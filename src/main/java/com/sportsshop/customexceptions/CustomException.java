package com.sportsshop.customexceptions;

public class CustomException extends RuntimeException {
	
    public CustomException(String message) {
        super(message);
    }
    
    public static class InvalidProductException extends CustomException {
    	
        public InvalidProductException(String message) {
            super(message);
        }
    }
    
    public static class UnableToConnectException extends CustomException {
    	
        public UnableToConnectException(String message) {
            super(message);
        }
    }
    
    public static class UnableToAccessException extends CustomException {
    	
        public UnableToAccessException(String message) {
            super(message);
        }
    }
}
