package com.esprit.secondapp.controllers;

import com.esprit.secondapp.entities.Employee;
import com.esprit.secondapp.services.EmployeeService;
import com.esprit.secondapp.services.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
    @Autowired
    private IEmployeeService iemployeeService;

	@GetMapping("/employee")
	  public List<Employee> getAllTutorials() {
		 return employeeService.getAllEmployee();
	    
	  }
	 
	 
	 @PostMapping("/save")
	 public Employee save(@RequestBody Employee employee) {
		 return iemployeeService.addEmployee(employee);
		 
	    
	  }
	 @DeleteMapping("/delete/{id}")
     public void supprimer(@PathVariable("id") String id){
         iemployeeService.deleteEmployeeById(id);

     }
     @GetMapping("/getbyid/{id}")
    public Employee GetById(@PathVariable("id") String id){
        return iemployeeService.getEmployeeById(id);
     }
     
     
     @PatchMapping("/update/{id}")
     public Employee patchUpdateEmployee(@PathVariable String id, @RequestBody Map<String, Object> updates) {
         return iemployeeService.updateEmployee(id,  updates);

     }

}
