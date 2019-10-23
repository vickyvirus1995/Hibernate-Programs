package com.vicky.SecondLevelCacheQuery;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.vicky.SecondLevelCacheQuery.Entity.Employee;




/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Session session = null;
    	SessionFactory factory = null;
    	try
    	{
    		
            Configuration cfg = new Configuration().configure().addAnnotatedClass(Employee.class);
            
            ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();
            factory = cfg.buildSessionFactory(reg);
            
            session = factory.openSession();
            
            
            Transaction tx = session.beginTransaction();
            
            
            Query q1 = session.createQuery("from employee where eid = 101");
            q1.setCacheable(true);
            Employee emp = (Employee)q1.uniqueResult();
            
            
            System.out.println("Emp Id       :  " + emp.getEid());
            System.out.println("Emp Name     :  " + emp.getName());
            System.out.println("Emp Salary   :  " + emp.getSalary());
            
            tx.commit();
            
            
            Session session2 = factory.openSession();
            
            
            Transaction tx2 = session.beginTransaction();
            
            
            Query q2 = session2.createQuery("from employee where eid = 101");
            	q2.setCacheable(true);
            emp = (Employee)q2.uniqueResult();
            
            System.out.println("Emp Id       :  " + emp.getEid());
            System.out.println("Emp Name     :  " + emp.getName());
            System.out.println("Emp Salary   :  " + emp.getSalary());
            
            tx2.commit();
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
