package com.demo.Entity;

public class Address {
	
	private String address;
	private String city;
	private int pincode;
	
	public Address(String address, String city, int pincode) {
		super();
		this.address = address;
		this.city = city;
		this.pincode = pincode;
	}

	public Address() {
		super();
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
		return "Address [address=" + address + ", city=" + city + ", pincode=" + pincode + "]";
	}
	
	

}
