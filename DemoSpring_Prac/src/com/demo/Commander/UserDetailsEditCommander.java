package com.demo.Commander;

import java.util.Arrays;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

import com.demo.ValidatorInf.EmailConstraint;
import com.demo.ValidatorInf.PhoneConstraint;

public class UserDetailsEditCommander {

	private long id;

	@NotEmpty(message = "Please enter a name")
	private String name;
	
	@Pattern(regexp="^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$", message="Please enter correct pattern")
	@EmailConstraint
    private String email; 

	@Pattern(regexp="^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",message="Atleast 8 characters. A number, a special character, a lowercase and an uppercase alphabet") 
    private String pass; 
	
	@PhoneConstraint
	private String phone;
	
	@NotNull(message = "Please select a gender")
	private String gender;
	
	private String[] interest;
	
	private String address;
	
	private String city;
	
	private int pincode;

	public UserDetailsEditCommander() {
	}

	public UserDetailsEditCommander(long id, @NotEmpty(message = "Please enter a name") String name, String email,
			String pass, String phone, String gender, String[] interest, String address, String city, int pincode) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.pass = pass;
		this.phone = phone;
		this.gender = gender;
		this.interest = interest;
		this.address = address;
		this.city = city;
		this.pincode = pincode;
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

	public String[] getInterest() {
		return interest;
	}

	public void setInterest(String[] interest) {
		this.interest = interest;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return "UserDetailsEditCommander [id=" + id + ", name=" + name + ", email=" + email + ", pass=" + pass
				+ ", phone=" + phone + ", gender=" + gender + ", interest=" + Arrays.toString(interest) + ", address="
				+ address + ", city=" + city + ", pincode=" + pincode + "]";
	}
	
	
}
