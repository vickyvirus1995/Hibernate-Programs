package com.vicky.Lazy;



import java.util.Collection;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.vicky.Lazy.Entity.Employee;
import com.vicky.Lazy.Entity.Laptop;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Configuration cfg = new Configuration().configure().addAnnotatedClass(Employee.class).addAnnotatedClass(Laptop.class);
    	
    	ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();
    	
    	SessionFactory factory = cfg.buildSessionFactory();
    	Session session = factory.openSession();
    	
    	Transaction tx = session.beginTransaction();
    	
    	Employee emp = (Employee)session.get(Employee.class, 101);
    	
    	System.out.println("Employee Id : " + emp.getEid());
    	System.out.println("Employee Name : " + emp.getName());
    	System.out.println("Employee Salary : " +emp.getSalary());
    	
    	Collection<Laptop> l = emp.getLaptop();
    	
    	for(Laptop laptop : l)
    	{
    		System.out.println(l);
    	}
    	
    	tx.commit();
    
    }
}
