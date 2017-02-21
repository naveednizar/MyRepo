package com.websystique.springboot.util;

public class CustomErrorType {
	
	public String errorMessage;
	
	public CustomErrorType (String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

}
