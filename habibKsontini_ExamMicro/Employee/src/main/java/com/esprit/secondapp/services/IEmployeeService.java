package com.esprit.secondapp.services;

import java.util.List;
import java.util.Map;

import com.esprit.secondapp.entities.Employee;


public interface IEmployeeService {

	Employee addEmployee(Employee employee);

	Employee updateEmployee(String id, Map<String, Object> stock);

	List<Employee> getAllEmployee();

	Employee getEmployeeById(String id);

	void deleteEmployeeById(String id);

}
