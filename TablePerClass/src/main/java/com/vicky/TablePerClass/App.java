package com.vicky.TablePerClass;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.vicky.TablePerClass.Entity.BackEndDeveloper;
import com.vicky.TablePerClass.Entity.FrontEndDeveloper;
import com.vicky.TablePerClass.Entity.FullStackDeveloper;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        FrontEndDeveloper front_end = new FrontEndDeveloper();
        front_end.setId(101);
        front_end.setName("rahul");
        front_end.setSalary(30000);
        front_end.setDesignation("Front End Developer");
        
        BackEndDeveloper back_end = new BackEndDeveloper();
        back_end.setId(102);
        back_end.setName("ambi");
        back_end.setSalary(40000);
        back_end.setDesignation("Back End Developer");
        
        FullStackDeveloper full_stack = new FullStackDeveloper();
        full_stack.setId(103);
        full_stack.setName("vicky");
        full_stack.setSalary(60000);
        full_stack.setDesignation("Full Stack Developer");
        
        
        Configuration cfg = new Configuration().configure();
        
        ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();
        
        SessionFactory factory = cfg.buildSessionFactory(registry);
        Session session = factory.openSession();
        
        Transaction tx = session.beginTransaction();
        
        session.save(front_end);
        session.save(back_end);
        session.save(full_stack);
        
        tx.commit();
       
        
        
    }
}
