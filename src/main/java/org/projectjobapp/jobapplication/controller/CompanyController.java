package org.projectjobapp.jobapplication.controller;

import org.projectjobapp.jobapplication.dto.CompanyDTO;
import org.projectjobapp.jobapplication.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {

    CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/get")
    public ResponseEntity<List<CompanyDTO>> getAllCompanies() {
        List<CompanyDTO> companyDTOS = companyService.getAllCompanies();
        return new ResponseEntity<>(companyDTOS, HttpStatus.OK);
    }

    @GetMapping("/get/{companyId}")
    public ResponseEntity<CompanyDTO> getCompaniesById(@PathVariable Long companyId) {
        CompanyDTO companyDTO = companyService.getCompanyById(companyId);
        return companyDTO != null ? new ResponseEntity<>(companyDTO, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/create")
    public ResponseEntity<CompanyDTO> createCompany(@RequestBody CompanyDTO companyDTO) {
        CompanyDTO company = companyService.createCompany(companyDTO);
        return new ResponseEntity<>(company, HttpStatus.CREATED);
    }

    @PutMapping("/update/{companyId}")
    public ResponseEntity<CompanyDTO> updateCompany(@PathVariable Long companyId, CompanyDTO companyDTO) {
        CompanyDTO company = companyService.updateCompany(companyId, companyDTO);
        return company != null ? new ResponseEntity<>(company, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/delete/{companyId}")
    public ResponseEntity<CompanyDTO> deleteCompany(@PathVariable Long companyId) {
        companyService.deleteCompany(companyId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
