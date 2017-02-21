package com.websystique.springboot.service;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.websystique.springboot.model.Users;
import com.websystique.springboot.repositories.RoleRepository;
import com.websystique.springboot.repositories.UsersRepository;

public class UsersServiceImpl implements UsersService {
	
	@Autowired
	public UsersRepository usersRepository;
	
	@Autowired
	public RoleRepository roleRepository;
	
	@Autowired
	public BCryptPasswordEncoder encoder;

	@Override
	public void save(Users user) {

		user.setPassword(encoder.encode(user.getPassword()));
		user.setRoles(new HashSet<>(roleRepository.findAll()));
		usersRepository.save(user);
	}

	@Override
	public Users findByUserName(String userName) {

		return usersRepository.findbyUserName(userName);
	}

}
