package com.vicky.NamedQueries.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@NamedQueries(
		{
			@NamedQuery(
					name="GetEmployeeData",
					query="from Employee4"
					)
		})


@Entity
public class Employee4 {
	
	@Id
	private int eid;
	private String name;
	private String salary;
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee4 [eid=" + eid + ", name=" + name + ", salary=" + salary + "]";
	}
	
	
	

}
