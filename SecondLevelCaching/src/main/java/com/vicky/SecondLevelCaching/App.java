package com.vicky.SecondLevelCaching;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.vicky.SecondLevelCaching.Entity.Employee;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Configuration cfg = new Configuration().configure().addAnnotatedClass(Employee.class);
    	
    	ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();
    	
    	SessionFactory factory = cfg.buildSessionFactory(reg);
    	
    	Session session = factory.openSession();
    	
    	Employee emp = null;
    	
    	Transaction tx = session.beginTransaction();
    	
    	emp=(Employee)session.get(Employee.class,101);
    
    	System.out.println(emp.getEid()+"\t"+emp.getName()+"\t"+emp.getSalary());
    	tx.commit();
    	
    	Session session1 = factory.openSession();
    	tx = session1.beginTransaction();
    	
    	emp=(Employee)session.get(Employee.class,101);
        
    	System.out.println(emp.getEid()+"\t"+emp.getName()+"\t"+emp.getSalary());
    	tx.commit();
    }
}
