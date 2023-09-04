package com.nervidper.courses.online.exception;

public class WrongPasswordException extends LoginException {

	public WrongPasswordException() {
		super("Wrong password");
	}

}
