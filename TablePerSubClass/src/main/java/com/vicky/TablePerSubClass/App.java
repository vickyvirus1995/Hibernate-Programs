package com.vicky.TablePerSubClass;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.vicky.TablePerSubClass.Entity.Android;
import com.vicky.TablePerSubClass.Entity.IOS;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Android android = new Android();
    	android.setName("Samsung On 8");
    	android.setOs_version("7.0");
    	android.setAmount(12000);
    	
    	IOS ios = new IOS();
    	ios.setName("Iphone 6s");
    	ios.setOs_version("12");
    	ios.setAmount(28000);
    	
        Configuration cfg = new Configuration().configure();
        
        ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();
        
        SessionFactory factory = cfg.buildSessionFactory(registry);
        
        Session session = factory.openSession();
        
        Transaction tx = session.beginTransaction();
        
        session.save(android);
        session.save(ios);
        
        tx.commit();
        
    }
}
