package com.exception;

import org.springframework.http.HttpStatus;

public class CustomGameException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	private HttpStatus status;
	public CustomGameException(String message, HttpStatus status) {
		super(message);
		this.message = message;
		this.status = status;
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @return the status
	 */
	public HttpStatus getStatus() {
		return status;
	}
	
	
	

}
