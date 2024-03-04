package org.projectjobapp.jobapplication.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long companyId;
    @Column(name = "company_name")
    private String companyName;
    @Column(name = "company_description")
    private String companyDescription;

    @JsonIgnore
    @OneToMany(mappedBy = "company" , cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Job> jobs;

    public Company() {
    }

    public Company(Long companyId, String companyName, String companyDescription, List<Job> jobs) {
        this.companyId = companyId;
        this.companyName = companyName;
        this.companyDescription = companyDescription;
        this.jobs = jobs;
    }



    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyDescription() {
        return companyDescription;
    }

    public void setCompanyDescription(String companyDescription) {
        this.companyDescription = companyDescription;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return Objects.equals(companyId, company.companyId) && Objects.equals(companyName, company.companyName) && Objects.equals(companyDescription, company.companyDescription) && Objects.equals(jobs, company.jobs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(companyId, companyName, companyDescription, jobs);
    }

    @Override
    public String toString() {
        return "Company{" +
                "companyId=" + companyId +
                ", companyName='" + companyName + '\'' +
                ", companyDescription='" + companyDescription + '\'' +
                ", jobs=" + jobs +
                '}';
    }
}
