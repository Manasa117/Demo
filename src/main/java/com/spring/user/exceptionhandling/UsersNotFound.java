package com.spring.user.exceptionhandling;

public class UsersNotFound extends Exception {
	
	String mess;

	public String getMess() {
		return mess;
	}

	public void setMess(String mess) {
		this.mess = mess;
	}

	public UsersNotFound(String mess) {
		super();
		this.mess = mess;
	}
	
	

}
