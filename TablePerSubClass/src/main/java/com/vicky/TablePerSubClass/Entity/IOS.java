package com.vicky.TablePerSubClass.Entity;

import javax.persistence.Entity;

@Entity
public class IOS extends Mobile{
	
	private String os_version;
	private int amount;
	public String getOs_version() {
		return os_version;
	}
	public void setOs_version(String os_version) {
		this.os_version = os_version;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	
}
