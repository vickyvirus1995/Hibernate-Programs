package Operation;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.vicky.HQLUpdate.Entity.Employee4;


public class DeleteData {

	public void deleteData()
	{

		Configuration cfg = new Configuration().configure();
        ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();
       SessionFactory factory = cfg.buildSessionFactory(registry);
       Session session = factory.openSession();
       Transaction tx = session.beginTransaction();
       
       Query query = session.createQuery("delete from Employee4 where eid = 103");
       query.executeUpdate();
       
       tx.commit();
       session.close();
       factory.close();
       

	}
}
