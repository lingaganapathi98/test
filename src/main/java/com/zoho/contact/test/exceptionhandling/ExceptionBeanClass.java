package com.zoho.contact.test.exceptionhandling;

public class ExceptionBeanClass {
	
	private String message;
	private String requestedURI;
	
	public String getErrorMessage() {
		return message;
	}
	public void setErrorMessage(String message) {
		this.message = message;
	}
	public String getRequestedURI() {
		return requestedURI;
	}
	public void setRequestedURI(String requestedURI) {
		this.requestedURI = requestedURI;
	}
	
	public void callerURL(final String reuestedURI) {
		this.requestedURI = requestedURI;
	}

}
