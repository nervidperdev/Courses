package com.nervidper.courses.online.exception;

public class UserNotLogged extends LoginException {

	public UserNotLogged() {
		super("User not logged.");
	}
}
