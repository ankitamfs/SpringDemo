package com.demo.ValidatorImpl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.demo.ServiceImpl.UserServiceImpl;
import com.demo.ValidatorInf.PhoneConstraint;

public class PhoneConstraintValidator implements
ConstraintValidator<PhoneConstraint, String>{

	@Override
	public void initialize(PhoneConstraint phone) {	
	}

	@Override
	public boolean isValid(String phoneField, ConstraintValidatorContext ctx) {
		
		return phoneField != null && phoneField.matches("[0-9]+")
		          && (phoneField.length() > 9) && (phoneField.length() < 14);
	}

}
