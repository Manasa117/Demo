package com.spring.user.exceptionhandling;

public class UserNotFoundByMailException extends Exception {
	String mess;

	public UserNotFoundByMailException(String mess) {
		super();
		this.mess = mess;
	}

	public String getMess() {
		return mess;
	}

	public void setMess(String mess) {
		this.mess = mess;
	}
	
	

}
