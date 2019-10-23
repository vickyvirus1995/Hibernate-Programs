package com.vicky.OneToOne.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Student {
	
	@Id
	private int sid;
	private String sname;
	private String city;
	
	@OneToOne
	private Programming programming;
	
	public Programming getProgramming() {
		return programming;
	}
	public void setProgramming(Programming programming) {
		this.programming = programming;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	

}
