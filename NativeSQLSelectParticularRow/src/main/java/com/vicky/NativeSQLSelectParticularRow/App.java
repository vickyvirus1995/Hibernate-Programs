package com.vicky.NativeSQLSelectParticularRow;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.vicky.NativeSQLSelectParticularRow.Entity.Employee4;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	SessionFactory factory = null;
    	Session session = null;
    	
        try
        {
        	Configuration cfg = new Configuration().configure().addAnnotatedClass(Employee4.class);
        	ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();
        	factory = cfg.buildSessionFactory();
        	session = factory.openSession();
        	Transaction tx = session.beginTransaction();
        	SQLQuery query = session.createSQLQuery("select name,salary from employee4 where salary like '6L'");
        	query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        	List emp = query.list();
        	
        	for(Object employee : emp)
        	{
        		Map emp_map = (Map) employee;
        		System.out.println("Name  :  " +emp_map.get("name")+"\t"+"Salary   :  "+emp_map.get("salary"));
        	}
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
