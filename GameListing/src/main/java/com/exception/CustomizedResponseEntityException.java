package com.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import com.response.Response;


@ControllerAdvice
public class CustomizedResponseEntityException extends ResponseEntityExceptionHandler {

	@ExceptionHandler(CustomGameException.class)
	public final ResponseEntity<Object> customHsmServiceException(CustomGameException ex, WebRequest request) {
		Response response = new Response<>();
		response.setMessage(ex.getMessage());
		response.setStatus(Integer.toString(ex.getStatus().value()));
		return new ResponseEntity(response, ex.getStatus());

	}

	@Override
	public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {

		Response response = new Response<>();
		response.setMessage(ex.getBindingResult().getFieldError().getDefaultMessage());
		response.setStatus(Integer.toString(status.value()));
		return new ResponseEntity(response, status);
	}

	    @Override
	    protected ResponseEntity<Object> handleMissingServletRequestParameter(
	            MissingServletRequestParameterException ex, HttpHeaders headers,
	            HttpStatus status, WebRequest request) {
	        String error = ex.getParameterName() + " parameter is missing as part of  url parameter ";
	        Response<String> response= new Response<String>();
	        response.setMessage(error);
	        response.setStatus(status.toString());
	        return new ResponseEntity<Object>(response,status);
	    }
}