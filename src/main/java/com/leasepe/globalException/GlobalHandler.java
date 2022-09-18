package com.leasepe.globalException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.leasepe.custom_exception.AccountHandlingException;
import com.leasepe.custom_exception.SellerHandlingException;
import com.leasepe.custom_exception.UserHandlingException;
import com.leasepe.dtos.ErrorResponse;

@ControllerAdvice
public class GlobalHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(AccountHandlingException.class)
	public ResponseEntity<?> handleAccountHandlingException(AccountHandlingException e) {
		System.out.println("in acct handling exc " + e);
		return new ResponseEntity<>(new ErrorResponse("Fetching User summary failed ", e.getMessage()),
				HttpStatus.NOT_FOUND);
	}



	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		return new ResponseEntity<>(new ErrorResponse("Requestbody is empty please add proper field ", ex.getMessage()),
				HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(SellerHandlingException.class) //can be array of  exception within ({})
	public ResponseEntity<?> handleSellerHandlingException(SellerHandlingException e) {
		
		return new ResponseEntity<>(new ErrorResponse("Seller Authentication Failed", e.getMessage()),
				HttpStatus.UNAUTHORIZED);
	}
	
	@ExceptionHandler(UserHandlingException.class) //can be array of  exception within ({})
	public ResponseEntity<?> handleUserHandlingException(UserHandlingException e) {
		
		return new ResponseEntity<>(new ErrorResponse("User Authentication Failed", e.getMessage()),
				HttpStatus.UNAUTHORIZED);
	}

}
