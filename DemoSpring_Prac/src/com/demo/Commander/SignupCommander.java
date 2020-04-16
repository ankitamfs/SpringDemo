package com.demo.Commander;

import java.util.Arrays;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

import com.demo.ValidatorInf.EmailConstraint;
import com.demo.ValidatorInf.EmailExistsConstraint;
import com.demo.ValidatorInf.PhoneConstraint;
import com.demo.ValidatorInf.PhoneExistsConstraint;

public class SignupCommander {

	@NotEmpty(message = "Please enter a name")
	private String name;
	
	@Pattern(regexp="^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$", message="Please enter correct pattern")
	@EmailExistsConstraint
	@EmailConstraint
    private String email; 

	@Pattern(regexp="^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",message="Atleast 8 characters. A number, a special character, a lowercase and an uppercase alphabet") 
    private String pass; 
	
	@PhoneConstraint
	@PhoneExistsConstraint
	private String phone;
	
	@NotNull(message = "Please select a gender")
	private String gender;
	
	private String[] interest;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email=email;
	}
	
	public String getPass() {
		return pass;
	}
	
	public void setPass(String pass) {
		this.pass=pass;
	}

	public String getGender() {  
        return gender;  
    }  
    public void setGender(String gender) {  
        this.gender = gender;  
    }     
	
    public String[] getInterest() {  
        return interest;  
    }  
    public void setInterest(String[] interest) {  
        this.interest = interest;  
    }

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "SignupCommander [name=" + name + ", email=" + email + ", pass=" + pass + ", phone=" + phone
				+ ", gender=" + gender + ", interest=" + Arrays.toString(interest) + "]";
	}        
	
	
}
