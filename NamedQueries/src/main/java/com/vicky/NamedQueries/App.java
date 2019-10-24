package com.vicky.NamedQueries;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.vicky.NamedQueries.Entity.Employee4;

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
        	factory = cfg.buildSessionFactory(registry);
        	session=factory.openSession();
        	
        	Query query = session.getNamedQuery("GetEmployeeData");
        	
        	List<Employee4> emp = query.list();
        	
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
