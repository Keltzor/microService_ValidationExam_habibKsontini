package com.esprit.firstapp.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
@AllArgsConstructor
public class CompanyWithEmployeeDTO {
	private Long id;
	private String name;
	private int size;
	private String id_employee;
	private EmployeeDTO employeedto;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public String getId_employee() {
		return id_employee;
	}
	public void setId_employee(String id_employee) {
		this.id_employee = id_employee;
	}
	public EmployeeDTO getEmployeedto() {
		return employeedto;
	}
	public void setEmployeedto(EmployeeDTO employeedto) {
		this.employeedto = employeedto;
	}
	public CompanyWithEmployeeDTO() {
		super();
	}

	
	

}
