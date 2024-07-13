package com.esprit.firstapp.repository;

import com.esprit.firstapp.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CompanyRepository extends JpaRepository<Company, Long> {

}
