package com.mcafee.customer.exception;

public class CustomerServiceException extends Exception {
	
	public CustomerServiceException() {
		super();
	}
	
	public CustomerServiceException(String message, int code) {
		super(message);
	}

}
