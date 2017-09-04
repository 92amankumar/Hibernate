package com.hibernate.HibernateTutorial;

import java.util.Calendar;

import javax.persistence.EntityManager;

import com.entities.Person;

public class PersistenceApp {
	public static void main(String[] args) {
		EntityManager entityManager = null;
		try {
			entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
			entityManager.getTransaction().begin();

			Person person = new Person();
			person.setFirstName("Aman");
			person.setMiddleName("Sunil");
			person.setLastName("Kumar");
			// Set DOB
			Calendar dob = Calendar.getInstance();
			dob.set(Calendar.DATE, 18);
			dob.set(Calendar.MONTH, 10);
			dob.set(Calendar.YEAR, 1992);
			dob.set(Calendar.HOUR_OF_DAY, 11);
			dob.set(Calendar.MINUTE, 45);
			dob.set(Calendar.SECOND, 0);
			dob.set(Calendar.MILLISECOND, 0);
			person.setDob(dob.getTime());

			// Save entity
			entityManager.persist(person);

			entityManager.getTransaction().commit();
			System.out.println("Person saved successfully");
		} catch (Exception e) {
			e.printStackTrace();
			if (entityManager != null) {
				System.out.println("Transaction is being rolled back.");
				entityManager.getTransaction().rollback();
			}
		} finally {
			if (entityManager != null) {
				entityManager.close();
			}
		}
		JPAUtil.shutdown();
	}
}
