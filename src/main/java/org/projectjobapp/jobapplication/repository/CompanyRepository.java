package org.projectjobapp.jobapplication.repository;

import org.projectjobapp.jobapplication.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
