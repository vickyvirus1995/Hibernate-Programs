package com.vicky.OneToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;


import com.vicky.OneToOne.Entity.Programming;
import com.vicky.OneToOne.Entity.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Programming programming = new Programming();
    	programming.setPid(1);
    	programming.setLanguage("java");
    	
    	Student student = new Student();
    	student.setSid(101);
    	student.setSname("vicky poojari");
    	student.setCity("mumbai");
    	student.setProgramming(programming);
    	Configuration cfg = new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Programming.class);
        ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();
        SessionFactory factory =  cfg.buildSessionFactory(reg);
        Session session = factory.openSession();
        
        org.hibernate.Transaction tx = session.beginTransaction();
        
        session.save(student);
        session.save(programming);
        
        tx.commit();

    }
}
