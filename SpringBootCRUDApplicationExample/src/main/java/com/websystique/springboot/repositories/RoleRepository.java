package com.websystique.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.websystique.springboot.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
