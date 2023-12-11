package com.spring.user.exceptionhandling;

public class UserNotFoundByNameException extends Exception {
	String mess;

	public UserNotFoundByNameException(String mess) {
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
