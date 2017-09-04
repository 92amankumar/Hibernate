package com.spring.service;

import java.util.List;

import com.spring.entity.Employee;

public interface EmployeeService {
	void add(Employee emp);
	List<Employee> listEmployees();
}
