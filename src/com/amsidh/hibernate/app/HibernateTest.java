package com.amsidh.hibernate.app;




import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import com.amsidh.hibernate.domains.UserDetails;

public class HibernateTest {

	
	public static void main(String[] args) {
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
        Query query=session.createQuery("select userName from userdetails");
        query.setFirstResult(5);
        query.setMaxResults(4);
		List<String> userNames=(List<String>)query.list();
		for (String string : userNames) {
			System.out.println(string);
		}
		
		session.getTransaction().commit();
		session.close();
		
		
		
	}

}
