package Operation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.vicky.HQLUpdate.Entity.Employee4;

public class InsertData {
	
	
	public void insertData()
	{
		try
		{
		
			Configuration cfg = new Configuration().configure();
	        ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();
	       SessionFactory factory = cfg.buildSessionFactory(registry);
	       for(int i=101;i<105;i++)
	       {
	    	   Session session = factory.openSession();
	           Transaction tx = session.beginTransaction();
	           
	           Employee4 emp = new Employee4();
	           emp.setEid(i);
	           emp.setName("rahul");
	           emp.setSalary(i-98+"L");
	           session.save(emp);
	           
	           tx.commit();
	           session.close();
	              
		}
	       factory.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
       }
       
       
       
	}

