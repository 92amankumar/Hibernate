package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dao.EmployeeDao;
import com.spring.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao dao;

	@Transactional
	@Override
	public void add(Employee emp) {
		dao.add(emp);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Employee> listEmployees() {
		return dao.listEmployees();
	}

}
