package com.demo.ValidatorImpl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.demo.Commander.LoginCommander;
import com.demo.ServiceImpl.UserServiceImpl;
import com.demo.ValidatorInf.PasswordErrorConstraint;

public class PasswordErrorValidator implements ConstraintValidator<PasswordErrorConstraint, String> {

	@Autowired
	UserServiceImpl userService;
	
	@Override
	public void initialize(PasswordErrorConstraint arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isValid(String password, ConstraintValidatorContext ctx) {
		
		boolean pass = false;
		
		LoginCommander user = new LoginCommander();
		System.out.println(user.getPass()+"  from commander");
		System.out.println(password+ "  from field");
		if (user.getPass() == password) {
			System.out.println("here");
			pass = userService.loginProcess(user);
		}	
		//System.out.println(pass);
		return pass;
	}

}
