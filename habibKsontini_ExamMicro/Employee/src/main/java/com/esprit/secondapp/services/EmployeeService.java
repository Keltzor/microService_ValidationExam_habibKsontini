package com.esprit.secondapp.services;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import com.esprit.secondapp.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.secondapp.repository.EmployeeRepository;

@Service
public class EmployeeService implements IEmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee addEmployee(Employee employee) {
		employeeRepository.save(employee);
		return employee;
	}

	@Override
	public Employee updateEmployee(String id, Map<String, Object> employee) {
		Employee existingEmployee = employeeRepository.findById(id).get();

		if (existingEmployee == null) {

			return null;
		}

		for (Map.Entry<String, Object> entry : employee.entrySet()) {
			String key = entry.getKey();
			Object value = entry.getValue();
			try {
				Field field = existingEmployee.getClass().getDeclaredField(key);
				field.setAccessible(true);
				field.set(existingEmployee, value);
			} catch (NoSuchFieldException | IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return employeeRepository.save(existingEmployee);
		 

	}

	@Override
	public List<Employee> getAllEmployee() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(String id) {
		return employeeRepository.findById(id).get();
	}

	@Override
	public void deleteEmployeeById(String id) {
		employeeRepository.deleteById(id);

	}

}
