package com.spring.dao;

import java.util.List;

import com.spring.entity.Employee;

public interface EmployeeDao {
	void add(Employee emp);
	List<Employee> listEmployees();
}
