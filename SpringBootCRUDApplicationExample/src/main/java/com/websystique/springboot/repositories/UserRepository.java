package com.websystique.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.websystique.springboot.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByName(String name);

}
