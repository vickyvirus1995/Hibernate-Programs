																																																																																																																											package com.vicky.TablePerHierarchy;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import com.vicky.TablePerHierarchy.Entity.ContractEmployee;
import com.vicky.TablePerHierarchy.Entity.RegularEmployee;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	RegularEmployee regular = new RegularEmployee();
    	regular.setName("nagesh");
    	regular.setSalary(50000);
    	regular.setBonus(25000);
    	
    	ContractEmployee contract = new ContractEmployee();
    	contract.setName("vicky");
    	contract.setPay_per_hour("500");
    	contract.setContract_duration("2 Years");
        AnnotationConfiguration cfg = new AnnotationConfiguration().configure();
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        
        session.save(regular);
        session.save(contract);
        
        tx.commit();
    }
}
