package com.esprit.firstapp.services;

import java.util.List;
import java.util.Map;

import com.esprit.firstapp.entities.Company;
import com.esprit.firstapp.entities.CompanyWithEmployeeDTO;

public interface ICompanyService {
	
	CompanyWithEmployeeDTO addCompany(CompanyWithEmployeeDTO company);

	Company updateCompany(Long id, Map<String, Object> company);

	List<CompanyWithEmployeeDTO> getAllCompany();

	CompanyWithEmployeeDTO getCompanyById(Long id);

	void deleteCompanyById(Long id);

}
