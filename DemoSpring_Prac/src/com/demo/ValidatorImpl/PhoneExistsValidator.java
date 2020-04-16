package com.demo.ValidatorImpl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.demo.ServiceImpl.UserServiceImpl;
import com.demo.ValidatorInf.PhoneExistsConstraint;

public class PhoneExistsValidator implements
ConstraintValidator<PhoneExistsConstraint, String>{
	
	@Autowired
	UserServiceImpl userService;
	
	@Override
	public void initialize(PhoneExistsConstraint phone) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isValid(String phoneField, ConstraintValidatorContext ctx) {
		boolean phone = false;
		if(userService.getUserPhone(phoneField) == "") {
			phone = true;
		}
		System.out.println(phone);
		return phone;
	}

	

}

