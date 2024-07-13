package com.esprit.secondapp.repository;

import com.esprit.secondapp.entities.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
public interface EmployeeRepository extends MongoRepository<Employee, String>{

}
