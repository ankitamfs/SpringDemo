package com.demo.Commander;

import javax.validation.constraints.Pattern;

public class VerifyPasswordCommander {
	
	@Pattern(regexp="^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",message="Atleast 8 characters. A number, a special character, a lowercase and an uppercase alphabet")
	private String newPassword;
	@Pattern(regexp="^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",message="Atleast 8 characters. A number, a special character, a lowercase and an uppercase alphabet")
	private String confirmPassword;
	@Pattern(regexp="^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$", message="Please enter correct pattern")
	private String email;
	
	public VerifyPasswordCommander() {
	}

	public VerifyPasswordCommander(String newPassword, String confirmPassword, String email) {
		super();
		this.newPassword = newPassword;
		this.confirmPassword = confirmPassword;
		this.email = email;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "VerifyPasswordCommander [newPassword=" + newPassword + ", confirmPassword=" + confirmPassword
				+ ", email=" + email + "]";
	}
		
}
