package com.vicky.HQLInsert;

import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.vicky.HQLInsert.Entity.Employee;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Configuration cfg = new Configuration().configure();
        ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();
       SessionFactory factory = cfg.buildSessionFactory(registry);
       Session session = factory.openSession();
       Transaction tx = session.beginTransaction();
       
       Employee emp = new Employee();
       Scanner input = new Scanner(System.in);
       System.out.print("\nEnter Employee Id :      ");
       emp.setEid(input.nextInt());
       System.out.print("\n\nEnter Employee Name :    ");
       emp.setName(input.next());
       System.out.print("\n\nEnter Employee Salary :    ");
       emp.setSalary(input.next());
       
       Query query = session.createQuery("update employee set salary = :b");
       
       
       tx.commit();
       session.close();
       factory.close();
       
       input.close();
       
       
    }
}
