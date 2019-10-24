package com.vicky.HCQL;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.vicky.HCQL.Entity.Employee4;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Configuration cfg = null;
        SessionFactory factory = null;
        Session session = null;
        
        
        try
        {
        	cfg = new Configuration().configure();
        	ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();
        	factory=cfg.buildSessionFactory(registry);
        	session=factory.openSession();
        	
        	Criteria c = session.createCriteria(Employee4.class);
        	c.add(Restrictions.gt("salary","10L"));
        	
        	List<Employee4> emp = c.list();
        	
        	
        	for(Employee4 employee : emp)
        	{
        		System.out.println(employee);
        	}
        	
        	 c = session.createCriteria(Employee4.class);
        	c.addOrder(Order.desc("eid"));
        	
        	emp = c.list();
        	
        	
        	for(Employee4 employee : emp)
        	{
        		System.out.println(employee);
        	}
        	
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
