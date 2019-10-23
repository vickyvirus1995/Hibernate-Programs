package com.vicky.NativeSQLSelectAll;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.vicky.NativeSQLSelectAll.Entity.Employee4;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Configuration cfg = new Configuration().configure().addAnnotatedClass(Employee4.class);
        ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();
        
        SessionFactory factory = cfg.buildSessionFactory(registry);
        Session session = factory.openSession();
        
        Transaction tx = session.beginTransaction();
        String sql_query = "Select * from employee4";
        SQLQuery query = session.createSQLQuery(sql_query);
        query.addEntity(Employee4.class);
        List<Employee4> emp = query.list();
        
        for(Employee4 employee : emp)
        {
        	System.out.println(employee);
        }
        
        tx.commit();
        session.close();
        factory.close();
    }
}
