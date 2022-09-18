package com.leasepe.custom_exception;

@SuppressWarnings("serial")
public class CategoryHandlingException extends RuntimeException {
public CategoryHandlingException(String mesg) {
	super(mesg);
}
@Override
public synchronized Throwable fillInStackTrace() {
    return this;
}

}
