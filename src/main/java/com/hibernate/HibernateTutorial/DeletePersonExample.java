package com.hibernate.HibernateTutorial;

import javax.persistence.EntityManager;

import com.entities.Person;

public class DeletePersonExample {
	public static void main(String[] args) {

		EntityManager entityManager = null;
		try {
			entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
			entityManager.getTransaction().begin();

			Person person = entityManager.find(Person.class, 1l);

			// Remove entity
			entityManager.remove(person);

			entityManager.getTransaction().commit();
			System.out.println("Person removed successfully");
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
