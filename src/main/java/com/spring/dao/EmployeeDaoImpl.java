package com.spring.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

import org.springframework.stereotype.Repository;

import com.spring.entity.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void add(Employee emp) {
		em.persist(emp);
	}

	@Override
	public List<Employee> listEmployees() {
		CriteriaQuery<Employee> criteriaQuery = em.getCriteriaBuilder().createQuery(Employee.class);
		criteriaQuery.from(Employee.class);
		return em.createQuery(criteriaQuery).getResultList();
	}

}
