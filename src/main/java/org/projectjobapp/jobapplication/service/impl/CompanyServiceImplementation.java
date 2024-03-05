package org.projectjobapp.jobapplication.service.impl;

import org.projectjobapp.jobapplication.dto.CompanyDTO;
import org.projectjobapp.jobapplication.dto.JobDTO;
import org.projectjobapp.jobapplication.entity.Company;
import org.projectjobapp.jobapplication.entity.Job;
import org.projectjobapp.jobapplication.repository.CompanyRepository;
import org.projectjobapp.jobapplication.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CompanyServiceImplementation implements CompanyService {


    private final CompanyRepository companyRepository;

    @Autowired
    public CompanyServiceImplementation(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public CompanyDTO mapToDTO(Company company) {
        if (company == null)
            return null;
        CompanyDTO companyDTO = new CompanyDTO();
        companyDTO.setCompanyId(company.getCompanyId());
        companyDTO.setCompanyName(company.getCompanyName());
        companyDTO.setCompanyDescription(company.getCompanyDescription());

        List<JobDTO> jobDTOS = new ArrayList<>();
        if (company.getJobs() != null) {
            jobDTOS = company.getJobs().stream()
                    .map(JobServiceImplementation::mapToDTOJob)
                    .collect(Collectors.toList());
        }
        companyDTO.setJobs(jobDTOS);

        return companyDTO;
    }

    public Company mapToEntity(CompanyDTO companyDTO) {
        if (companyDTO == null)
            return null;
        Company company = new Company();
        company.setCompanyId(companyDTO.getCompanyId());
        company.setCompanyName(companyDTO.getCompanyName());
        company.setCompanyDescription(companyDTO.getCompanyDescription());
        List<Job> jobs = new ArrayList<>();
        if (companyDTO.getJobs() != null) {
            jobs = companyDTO.getJobs().stream()
                    .map(JobServiceImplementation::mapToEntityJob)
                    .collect(Collectors.toList());
        }
        company.setJobs(jobs);
        return company;
    }

    @Override
    public List<CompanyDTO> getAllCompanies() {
        List<Company> companyList = companyRepository.findAll();
        return companyList.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CompanyDTO getCompanyById(Long companyId) {
        Optional<Company> company = companyRepository.findById(companyId);
        return company.map(this::mapToDTO)
                .orElse(null);
    }

    @Override
    public CompanyDTO createCompany(CompanyDTO companyDTO) {
        Company company = mapToEntity(companyDTO);
        Company saveCompany = companyRepository.save(company);
        return mapToDTO(saveCompany);
    }


    //Issue with Update method the update method is return and storing null values.
    @Override
    public CompanyDTO updateCompany(Long companyId, CompanyDTO companyDTO) {
        if (companyId == null || companyDTO == null) {
            return null;
        }
        Company existingSaveCompany = companyRepository.findById(companyId)
                .orElse(null);

        if (existingSaveCompany == null) {
            return null;
        }
        existingSaveCompany.setCompanyName(companyDTO.getCompanyName());
        existingSaveCompany.setCompanyDescription(companyDTO.getCompanyDescription());
        if (companyDTO.getJobs() != null && !companyDTO.getJobs().isEmpty()) {
            List<Job> jobs = companyDTO.getJobs().stream()
                    .map(JobServiceImplementation::mapToEntityJob)
                    .collect(Collectors.toList());
            existingSaveCompany.setJobs(jobs);
        } else {
            existingSaveCompany.getJobs().clear();
        }
        existingSaveCompany = companyRepository.save(existingSaveCompany);
        return mapToDTO(existingSaveCompany);
    }

    @Override
    public void deleteCompany(Long companyId) {
        companyRepository.deleteById(companyId);
    }
}
