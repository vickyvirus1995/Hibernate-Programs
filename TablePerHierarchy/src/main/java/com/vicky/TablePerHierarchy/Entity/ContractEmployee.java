package com.vicky.TablePerHierarchy.Entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("ContractEmployee")
public class ContractEmployee extends Employee {
	
	private String contract_duration;
	private String pay_per_hour;
	public String getContract_duration() {
		return contract_duration;
	}
	public void setContract_duration(String contract_duration) {
		this.contract_duration = contract_duration;
	}
	public String getPay_per_hour() {
		return pay_per_hour;
	}
	public void setPay_per_hour(String pay_per_hour) {
		this.pay_per_hour = pay_per_hour;
	}

	
}
