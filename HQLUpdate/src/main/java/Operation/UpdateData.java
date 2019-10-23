package Operation;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class UpdateData {
	
	
	public void updateData()
	{
		Configuration cfg = new Configuration().configure();
		ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		Query query = session.createQuery("Update Employee4 set salary = :b where eid = 102");
		query.setParameter("b", "10L");
		query.executeUpdate();

		tx.commit();
		session.close();
		factory.close();
	}

}
