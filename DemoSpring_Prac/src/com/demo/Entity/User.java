package com.demo.Entity;

import java.sql.Array;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.demo.ValidatorInf.EmailConstraint;
import com.demo.ValidatorInf.PhoneConstraint;

public class User {

	private long id;
	
	private String name;
    private String email;
    private String pass; 
	private String phone;
	private boolean active;
	private String gender;	
	private String[] interest;
	private String role;
	private int roleId;
	private Address address;
	
	public User() {
		
	}
	
	public User(String name, String email, String pass, String phone,
			String gender, String[] interest, boolean active, String role, int roleId, Address address) {
		this.name = name;
		this.email = email;
		this.pass = pass;
		this.phone = phone;
		this.gender = gender;
		this.interest = interest;
		this.active = active;
		this.role = role;
		this.roleId = roleId;
		this.address = address;
	}


	
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

	public boolean isActive() {
		return active;
	}
	
	public boolean getActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	
}
