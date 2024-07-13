package com.esprit.firstapp.mappers;

import com.esprit.firstapp.entities.Company;
import com.esprit.firstapp.entities.EmployeeDTO;
import com.esprit.firstapp.entities.CompanyWithEmployeeDTO;

public class CompanyMappers {

	public static CompanyWithEmployeeDTO mapToDto(Company company) {

		CompanyWithEmployeeDTO companyDTO = CompanyWithEmployeeDTO.builder().id(company.getId()).name(company.getName())
				.size(company.getSize()).id_employee(company.getId_employee()).build();
		return companyDTO;
	}

	public static CompanyWithEmployeeDTO mapToDto(Company company, EmployeeDTO employeeDTO) {

		CompanyWithEmployeeDTO companyDTO = CompanyWithEmployeeDTO.builder().id(company.getId()).name(company.getName())
				.size(company.getSize()).id_employee(company.getId_employee()).employeedto(employeeDTO).build();

		return companyDTO;
	}

	public static Company mapToEntity(CompanyWithEmployeeDTO companyDTO) {
		Company company = Company.builder().id(companyDTO.getId()).name(companyDTO.getName()).size(companyDTO.getSize())
				.id_employee(companyDTO.getEmployeedto().getId()).build();
		return company;

	}

}
