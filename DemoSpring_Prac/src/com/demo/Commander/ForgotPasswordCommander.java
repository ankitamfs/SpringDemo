package com.demo.Commander;

import com.demo.ValidatorInf.EmailConstraint;

public class ForgotPasswordCommander {

	@EmailConstraint
	private String email;
	
	public ForgotPasswordCommander() {
		
	}

	public ForgotPasswordCommander(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "ForgotPasswordCommander [email=" + email + "]";
	}	
	
	
	
}
