package org.projectjobapp.jobapplication.dto;

import org.projectjobapp.jobapplication.entity.Company;

public class JobDTO {
    private Long jobId;
    private String jobTitle;
    private String jobDescription;
    private Integer jobMinSalary;
    private Integer jobMaxSalary;
    private String Location;
    private Company company;

    public JobDTO() {

    }

    public JobDTO(Long jobId, String jobTitle, String jobDescription, Integer jobMinSalary, Integer jobMaxSalary, String location) {
        this.jobId = jobId;
        this.jobTitle = jobTitle;
        this.jobDescription = jobDescription;
        this.jobMinSalary = jobMinSalary;
        this.jobMaxSalary = jobMaxSalary;
        Location = location;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public Integer getJobMinSalary() {
        return jobMinSalary;
    }

    public void setJobMinSalary(Integer jobMinSalary) {
        this.jobMinSalary = jobMinSalary;
    }

    public Integer getJobMaxSalary() {
        return jobMaxSalary;
    }

    public void setJobMaxSalary(Integer jobMaxSalary) {
        this.jobMaxSalary = jobMaxSalary;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }


}
