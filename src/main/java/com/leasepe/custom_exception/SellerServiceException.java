package com.leasepe.custom_exception;

@SuppressWarnings("serial")
public class SellerServiceException extends RuntimeException {
public SellerServiceException(String mesg) {
	super(mesg);
}
}
