package com.spring.config;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.entity.Employee;
import com.spring.service.EmployeeService;

public class MainApp {
	public static void main(String[] args) {
		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class)) {
			EmployeeService service = context.getBean(EmployeeService.class);
			/*Employee emp = new Employee();
			emp.setName("Aman");
			emp.setDesignation("SSE");
			emp.setSalary(50000);

			List<Address> list = new ArrayList<>();
			Address address1 = new Address();
			address1.setCity("PKL");
			address1.setCountry("IN");
			address1.setState("HY");
			address1.setZip("134109");
			list.add(address1);

			Address address2 = new Address();
			address2.setCity("HJJ");
			address2.setCountry("IN");
			address2.setState("HH");
			address2.setZip("345353");
			list.add(address2);
			emp.setAddresses(list);

			service.add(emp);*/

			List<Employee> employees = service.listEmployees();
			for (Employee employee : employees) {
				System.out.println(employee);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
