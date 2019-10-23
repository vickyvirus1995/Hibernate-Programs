package com.vicky.HQLSelect;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.vicky.HQLSelect.Entity.Employee;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Configuration cfg = new Configuration().configure();
    	ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();
    	SessionFactory factory = cfg.buildSessionFactory();
    	Session session = factory.openSession();
    	Transaction tx = session.beginTransaction();
    	
    	System.out.println("====================Complete Data List retrieve=================");
    	
    	Query query = session.createQuery("from Employee");
    	List<Employee> emp = (List<Employee>)query.list();
    	
    	for(Employee employee : emp)
    	{
    		System.out.println(employee);
    	}
    	
    	tx.commit();
    	
    	System.out.println("===================Single Row retrieve=================");
    	
    	tx = session.beginTransaction();
    	query = session.createQuery("from Employee where eid =102");
    	Employee employee = (Employee)query.uniqueResult();
    	System.out.println(employee);
    	tx.commit();
    	employee=null;
    	
    	
    	System.out.println("===================Retrieve particular row =========================");
    	tx = session.beginTransaction();
    	query = session.createQuery("Select eid,name from Employee");
    	List<Object[]> employee1 = (List<Object[]>)query.list();
    	
    	for(Object[] obj : employee1)
    	{
    		System.out.println("\nEmployee Details");
    		System.out.println("Id  : " + obj[0]);
    		System.out.println("Name  : " + obj[1]);
    		
    	}
    	
    	tx.commit();
    	
    	
    	session.close();
    	factory.close();
    }
}
