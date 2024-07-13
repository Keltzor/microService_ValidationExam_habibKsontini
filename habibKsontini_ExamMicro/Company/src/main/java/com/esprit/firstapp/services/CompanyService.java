package com.esprit.firstapp.services;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.esprit.firstapp.entities.Company;
import com.esprit.firstapp.entities.EmployeeDTO;
import com.esprit.firstapp.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.esprit.firstapp.entities.CompanyWithEmployeeDTO;
import com.esprit.firstapp.mappers.CompanyMappers;

@Service
public class CompanyService implements ICompanyService {
	@Autowired
	private EmployeeClient employeeClient;

	@Autowired
	private CompanyRepository companyRepository;

	@Override
	public CompanyWithEmployeeDTO addCompany(CompanyWithEmployeeDTO companyDto) {
		 companyRepository.save(CompanyMappers.mapToEntity(companyDto));
		return companyDto;
		
	}

	@Override
	public List<CompanyWithEmployeeDTO> getAllCompany() {

		return companyRepository.findAll().stream().map(company -> CompanyMappers.mapToDto(company))
				.collect(Collectors.toList());
	}

	@Override
	public CompanyWithEmployeeDTO getCompanyById(Long id) {
		Company company = companyRepository.findById(id).orElseThrow(() -> new RuntimeException("Company not found for id: " + id));
		
		//OpenFeign
		EmployeeDTO employeeDTO = employeeClient.getById(company.getId_employee());
		
		//RestTemplate
		//EmployeeDTO employeeDTO =getById(company.getId_employee());
		return CompanyMappers.mapToDto(company, employeeDTO);
	}


	@Override
	public Company updateCompany(Long id, Map<String, Object> article) {
		Company existingCompany = companyRepository.findById(id).get();

		if (existingCompany == null) {

			return null;
		}

		for (Map.Entry<String, Object> entry : article.entrySet()) {
			String key = entry.getKey();
			Object value = entry.getValue();
			try {
				Field field = existingCompany.getClass().getDeclaredField(key);
				field.setAccessible(true);
				field.set(existingCompany, value);
			} catch (NoSuchFieldException | IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return companyRepository.save(existingCompany);
	}

	@Override
	public void deleteCompanyById(Long id) {
		companyRepository.deleteById(id);

	}

	public EmployeeDTO getById(String id) {
		String url = "http://localhost:8090/api/getbyid/" + id;
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForObject(url, EmployeeDTO.class);
	}

}
