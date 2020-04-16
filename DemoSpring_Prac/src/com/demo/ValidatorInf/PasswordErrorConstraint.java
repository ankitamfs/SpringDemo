package com.demo.ValidatorInf;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.demo.ValidatorImpl.PasswordErrorValidator;


@Constraint(validatedBy = PasswordErrorValidator.class)  
@Target( { ElementType.METHOD, ElementType.FIELD } )  
@Retention(RetentionPolicy.RUNTIME)

public @interface PasswordErrorConstraint {
	
	String message() default "Incorrect Password!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
