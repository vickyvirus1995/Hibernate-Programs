package com.vicky.Log4J;


import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.vicky.Log4J.Entity.Employee;

/**
 * Hello world!
 *
 */
public class App 
{
	
private final static Logger logger = Logger.getLogger(App.class);
	
static
{
	init();
}
	private static void init() {
		PropertyConfigurator.configure("src//main//java//log4j.properties");
	}
    public static void main( String[] args )
    {
    	Session session = null;
    	SessionFactory factory = null;
    	try
    	{
    		logger.info("Configuration Setting Up ");
            Configuration cfg = new Configuration().configure().addAnnotatedClass(Employee.class);
            
            ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();
            factory = cfg.buildSessionFactory(reg);
            
            session = factory.openSession();
            
            logger.info("Transaction Started");
            Transaction tx = session.beginTransaction();
            
            logger.info("Employee Object Fetching");
            Employee emp = (Employee)session.get(Employee.class,103);
            
            logger.info("Employee Details Printing");
            System.out.println("Emp Id       :  " + emp.getEid());
            System.out.println("Emp Name     :  " + emp.getName());
            System.out.println("Emp Salary   :  " + emp.getSalary());
            
            tx.commit();
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    	finally
    	{
    		session.close();
    		factory.close();
    	}
    	
    }
}
