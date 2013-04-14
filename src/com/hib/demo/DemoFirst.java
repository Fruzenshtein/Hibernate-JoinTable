package com.hib.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.hib.entities.Role;
import com.hib.entities.User;
import com.hib.init.HibernateUtil;

public class DemoFirst {

	public static void main(String[] args) {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Role role = (Role) session.get(Role.class, 2);

		User user = new User("Alex", "111111");
		user.setRole(role);
		
		session.save(user);
		
		session.getTransaction().commit();
		
		session.close();

	}

}
