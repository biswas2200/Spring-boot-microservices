package org.projectjobapp.jobapplication.dto;

import java.util.List;
import java.util.Objects;

public class CompanyDTO {
    private Long companyId;
    private String companyName;
    private String companyDescription;
    private List<JobDTO> jobs;

    public CompanyDTO() {
    }

    public CompanyDTO(Long companyId, String companyName, String companyDescription, List<JobDTO> jobs) {
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

    public List<JobDTO> getJobs() {
        return jobs;
    }

    public void setJobs(List<JobDTO> jobs) {
        this.jobs = jobs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompanyDTO that = (CompanyDTO) o;
        return Objects.equals(companyId, that.companyId) && Objects.equals(companyName, that.companyName) && Objects.equals(companyDescription, that.companyDescription) && Objects.equals(jobs, that.jobs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(companyId, companyName, companyDescription, jobs);
    }

    @Override
    public String toString() {
        return "CompanyDTO{" +
                "companyId=" + companyId +
                ", companyName='" + companyName + '\'' +
                ", companyDescription='" + companyDescription + '\'' +
                ", jobs=" + jobs +
                '}';
    }
}
