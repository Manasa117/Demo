package com.spring.user.exceptionhandling;

public class UserNotFoundByIdException extends RuntimeException {
	
	String mess ;
	
	public UserNotFoundByIdException(String mess) {
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
