package com.vicky.SetMapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.vicky.SetMapping.Entity.Address;
import com.vicky.SetMapping.Entity.Client;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       Address add1 = new Address();
       add1.setRno("1504");
       add1.setStreet_name("electronic city");
       add1.setPincode("560001");
       
       Address add2 = new Address();
       add2.setRno("102");
       add2.setStreet_name("Near Race Course");
       add2.setPincode("560004");
       
       
       Client client = new Client();
       client.setId(1);
       client.setName("TCS");
       client.getAddresses().add(add1);
       client.getAddresses().add(add2);
       
       
       
       Configuration cfg = new Configuration().configure().addAnnotatedClass(Client.class);
       ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();
       SessionFactory factory = cfg.buildSessionFactory(reg);
       Session session = factory.openSession();
       
       Transaction tx = session.beginTransaction();
       
       session.save(client);
       
       tx.commit();
       
       session.close();
       factory.close();
       
       
       
    }
}
