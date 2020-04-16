package com.demo.Commander;

import javax.validation.constraints.Pattern;


public class LoginCommander {
	
	@Pattern(regexp="^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$", message="Please enter correct pattern")
	private String email;
	
	@Pattern(regexp="^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",message="Atleast 8 characters. A number, a special character, a lowercase and an uppercase alphabet")
	private String pass;
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	@Override
	public String toString() {
		return "LoginCommander [email=" + email + ", pass=" + pass + "]";
	}
	
	
}
