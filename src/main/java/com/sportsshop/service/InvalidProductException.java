package com.sportsshop.service;

public class InvalidProductException extends Exception {
	private String message;
	
	public InvalidProductException(String message) {
		this.message = message;
	}
	@Override
	public String getMessage() {
		return message;
		
	}
}