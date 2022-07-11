package com.ashok.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ExceptionStatus extends Exception {

	public ExceptionStatus() {
		
	}
	
	public ExceptionStatus(String message) {
		super(message);
	}
}
