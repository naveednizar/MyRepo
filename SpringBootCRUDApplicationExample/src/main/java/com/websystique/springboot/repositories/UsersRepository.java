package com.websystique.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.websystique.springboot.model.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {
	
	Users findbyUserName(String userName);

}
