package com.zoho.contact.test.exceptionhandling;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


public class ControllerExceptionhandling {
	
	@ExceptionHandler(IdNotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ResponseBody
	public ExceptionBeanClass handleResourceNotFound(final IdNotFoundException exception, final HttpServletRequest request) {
		
		ExceptionBeanClass error = new ExceptionBeanClass();
		error.setErrorMessage(exception.getMessage());
		error.callerURL(request.getRequestURI());
		return error;
	}

}
