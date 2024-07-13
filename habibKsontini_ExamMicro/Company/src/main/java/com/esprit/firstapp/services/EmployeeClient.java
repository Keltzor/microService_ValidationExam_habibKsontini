package com.esprit.firstapp.services;

import com.esprit.firstapp.entities.EmployeeDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "api", url = "http://localhost:8090") 
public interface EmployeeClient {
	
	 @GetMapping("/api/getbyid/{id}")
	 EmployeeDTO getById(@PathVariable("id") String id);
	 
	 

}
