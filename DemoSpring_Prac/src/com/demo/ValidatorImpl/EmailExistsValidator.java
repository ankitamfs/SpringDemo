package com.demo.ValidatorImpl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.demo.ServiceImpl.UserServiceImpl;
import com.demo.ValidatorInf.EmailExistsConstraint;

public class EmailExistsValidator implements
ConstraintValidator<EmailExistsConstraint, String>{
	
	@Autowired
	UserServiceImpl userService;

	@Override
	public void initialize(EmailExistsConstraint arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isValid(String emailField, ConstraintValidatorContext ctx) {
		boolean email = false;
		if(userService.getUserEmail(emailField) == "") {
			email = true;
		}
		System.out.println("Validator:"+email);
		return email;
		
	}

}
