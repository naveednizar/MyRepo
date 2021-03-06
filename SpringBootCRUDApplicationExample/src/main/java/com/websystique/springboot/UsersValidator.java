package com.websystique.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.websystique.springboot.model.Users;
import com.websystique.springboot.service.UsersService;

public class UsersValidator implements Validator {

	@Autowired
	public UsersService userService;
	
	@Override
	public boolean supports(Class<?> aClass) {

		return Users.class.equals(aClass);
	}

	@Override
	public void validate(Object o, Errors errors) {

		Users users = (Users) o;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "notempty");
		if(users.getUsername().length() < 6 || users.getUsername().length() > 32) {
			errors.rejectValue("username", "Size.userForm.username");
		}
		
		if(userService.findByUserName(users.getUsername()) != null) {
			errors.rejectValue("username", "Size.userForm.username");
		}
		
	}

}
