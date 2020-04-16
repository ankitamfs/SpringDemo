package com.demo.Entity;

import java.util.Arrays;

public class UserDTO {
	
	private long id;
	private String name;
	private String password;
	private String email;
	private String phone;
	private String gender;
	private boolean active;
	private String[] interest;
	
	public UserDTO() {
		
	}
	
	public UserDTO(long id, String name, String password, String email, String phone, String gender, boolean active,
			String[] interest) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.gender = gender;
		this.active = active;
		this.interest = interest;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String[] getInterest() {
		return interest;
	}

	public void setInterest(String[] interest) {
		this.interest = interest;
	}

	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", name=" + name + ", password=" + password + ", email=" + email + ", phone="
				+ phone + ", gender=" + gender + ", active=" + active + ", interest=" + Arrays.toString(interest) + "]";
	}
	
	
}
