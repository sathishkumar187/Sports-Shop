package com.sportsshop.customexceptions;

public class CustomException extends RuntimeException {
	
    public CustomException(final String message) {
        super(message);
    }
    
    public static class InvalidProductException extends CustomException {
    	
        public InvalidProductException(final String message) {
            super(message);
        }
    }
    
    public static class UnableToConnectException extends CustomException {
    	
        public UnableToConnectException(final String message) {
            super(message);
        }
    }
    
    public static class UnableToAccessException extends CustomException {
    	
        public UnableToAccessException(final String message) {
            super(message);
        }
    }
}
