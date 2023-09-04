package com.nervidper.courses.online.exception;

public class RegistrationException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public RegistrationException() {
		super("Cannot register user");
	}

}
