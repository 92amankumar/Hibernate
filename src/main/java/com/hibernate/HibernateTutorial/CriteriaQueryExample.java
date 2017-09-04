package com.hibernate.HibernateTutorial;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.entities.Person;

public class CriteriaQueryExample {
	public static void main(String[] args) {
		EntityManager entityManager = null;
		try {
			entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
			CriteriaBuilder builder = entityManager.getCriteriaBuilder();
			CriteriaQuery<Person> query = builder.createQuery(Person.class);
			Root<Person> root = query.from(Person.class);
			query.select(root);
			Predicate predicate = builder.equal(builder.upper(root.<String> get("firstName")), "AMAN");
			query.where(predicate);
			query.orderBy(builder.asc(root.get("id")));
			System.out.println("Criteria successful");
			List<Person> Persons = entityManager.createQuery(query).getResultList();
			for (Person person : Persons) {
				System.out.println(person.getId());
				System.out.println(person.getFirstName());
				System.out.println(person.getLastName());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (entityManager != null) {
				entityManager.close();
			}
		}
		JPAUtil.shutdown();

	}
}
