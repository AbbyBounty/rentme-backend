package com.leasepe.custom_exception;

@SuppressWarnings("serial")
public class OrderHandlingException extends RuntimeException {
public OrderHandlingException(String mesg) {
	super(mesg);
}
@Override
public synchronized Throwable fillInStackTrace() {
    return this;
}

}
