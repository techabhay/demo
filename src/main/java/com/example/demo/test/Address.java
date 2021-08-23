package com.example.demo.test;

public class Address {
	
	String streetAddress;
	int pinCode;	
	
	public Address(String streetAddress, int pinCode) {
		super();
		this.streetAddress = streetAddress;
		this.pinCode = pinCode;
	}	
	
	public String getStreetAddress() {
		return streetAddress;
	}
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}
	public int getPinCode() {
		return pinCode;
	}
	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}
	public Address getAddressObj() {
		return this;
	}
	
	public String toString() {
		return "StrtAddrs : " + this.getStreetAddress() + "\t" + "PinCode : " + this.getPinCode();
	}
}
