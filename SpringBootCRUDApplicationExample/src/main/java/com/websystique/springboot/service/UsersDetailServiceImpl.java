package com.websystique.springboot.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import com.websystique.springboot.model.Role;
import com.websystique.springboot.model.Users;
import com.websystique.springboot.repositories.UsersRepository;

public class UsersDetailServiceImpl implements UserDetailsService {

	@Autowired
	public UsersRepository usersRepository;
	
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		
		Users user = usersRepository.findbyUserName(userName);
		
		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
		
		for(Role role: user.getRoles()) {
			grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
		}
		return new User(user.getUsername(), user.getPassword(), grantedAuthorities);
	}

}
