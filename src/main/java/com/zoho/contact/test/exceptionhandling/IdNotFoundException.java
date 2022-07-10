package com.zoho.contact.test.exceptionhandling;

public class IdNotFoundException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public IdNotFoundException() {
		super();
	}
	
	public IdNotFoundException(final String message) {
		super(message);
	}

}
