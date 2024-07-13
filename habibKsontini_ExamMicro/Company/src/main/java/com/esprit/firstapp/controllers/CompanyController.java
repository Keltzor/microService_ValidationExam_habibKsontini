package com.esprit.firstapp.controllers;

import java.util.List;
import java.util.Map;

import com.esprit.firstapp.entities.Company;
import com.esprit.firstapp.services.ICompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.firstapp.entities.CompanyWithEmployeeDTO;

@RestController
@RequestMapping("/api/Company")

public class CompanyController {

	@Autowired
	private ICompanyService companyService;

	@GetMapping("/company")
	public List<CompanyWithEmployeeDTO> getAllTutorials() {
		return companyService.getAllCompany();

	}

	@PostMapping("/save")
	public CompanyWithEmployeeDTO save(@RequestBody CompanyWithEmployeeDTO company) {
		return companyService.addCompany(company);

	}

	@DeleteMapping("/delete/{id}")
	public void supprimer(@PathVariable("id") Long id) {
		companyService.deleteCompanyById(id);

	}

	@GetMapping("/getbyid/{id}")
	public CompanyWithEmployeeDTO GetById(@PathVariable("id") Long id) {
		return companyService.getCompanyById(id);
	}

	@PatchMapping("/update/{id}")
	public Company patchUpdateItem(@PathVariable Long id, @RequestBody Map<String, Object> updates) {
		return companyService.updateCompany(id, updates);

	}

}
