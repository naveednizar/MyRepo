package com.websystique.springboot.service;

public interface SecurityService {
	
	String findLoggedInUserName();
	
	void autoLogin(String userName, String password);

}
