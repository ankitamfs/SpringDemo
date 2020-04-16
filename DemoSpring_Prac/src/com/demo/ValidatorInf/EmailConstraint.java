package com.demo.ValidatorInf;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.demo.ValidatorImpl.EmailConstraintValidator;

@Documented
@Constraint(validatedBy = EmailConstraintValidator.class)
@Target({ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)

public @interface EmailConstraint {
 
public String message() default "SMTP Validation Error!";
	
	//represents group of constraints     
    public Class<?>[] groups() default {};  
    
    //represents additional information about annotation  
    public Class<? extends Payload>[] payload() default {};
}
