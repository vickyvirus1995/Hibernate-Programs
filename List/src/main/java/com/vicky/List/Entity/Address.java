package com.vicky.List.Entity;

import javax.persistence.Embeddable;
import javax.persistence.Table;

@Embeddable
@Table(name="AddressList")
public class Address {
	
	private String rno;
	private String street_name;
	private String pincode;
	public String getRno() {
		return rno;
	}
	public void setRno(String rno) {
		this.rno = rno;
	}
	public String getStreet_name() {
		return street_name;
	}
	public void setStreet_name(String street_name) {
		this.street_name = street_name;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	
	

}
