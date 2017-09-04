package com.hibernate.HibernateTutorial;

import java.sql.Timestamp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class HibernateApp {
	public static void main(String[] args) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		try {
			String sql = "SELECT SYSDATE FROM DUAL";
			Timestamp timestamp = (Timestamp) session.createNativeQuery(sql).getSingleResult();
			System.out.println(timestamp.toString());
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		session.close();
		HibernateUtils.shutdown();
	}
}
