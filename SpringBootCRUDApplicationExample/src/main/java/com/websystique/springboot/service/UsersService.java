package com.websystique.springboot.service;

import com.websystique.springboot.model.Users;

public interface UsersService {

	void save(Users user);
	Users findByUserName(String userName);
}
