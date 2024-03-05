package org.projectjobapp.jobapplication.entity;

import jakarta.persistence.*;

@Entity
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long jobId;
    @Column(name = "job_title")
    private String jobTitle;
    @Column(name = "job_description")
    private String jobDescription;
    @Column(name = "job_min_salary")
    private Integer jobMinSalary;
    @Column(name = "job_max_salary")
    private Integer jobMaxSalary;
    private String Location;
    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;
    public Job() {
    }

    public Job(Long jobId, String jobTitle, String jobDescription, Integer jobMinSalary, Integer jobMaxSalary, String location) {
        this.jobId = jobId;
        this.jobTitle = jobTitle;
        this.jobDescription = jobDescription;
        this.jobMinSalary = jobMinSalary;
        this.jobMaxSalary = jobMaxSalary;
        Location = location;
    }

    public Job(Long jobId, String jobTitle, String jobDescription, Integer jobMinSalary, Integer jobMaxSalary, String location, Company company) {
        this.jobId = jobId;
        this.jobTitle = jobTitle;
        this.jobDescription = jobDescription;
        this.jobMinSalary = jobMinSalary;
        this.jobMaxSalary = jobMaxSalary;
        Location = location;
        this.company = company;
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


   /* @Override
    public String toString() {
        return "Job{" +
                "jobId=" + jobId +
                ", jobTitle='" + jobTitle + '\'' +
                ", jobDescription='" + jobDescription + '\'' +
                ", jobMinSalary=" + jobMinSalary +
                ", jobMaxSalary=" + jobMaxSalary +
                ", Location='" + Location + '\'' +
                ", company=" + company +
                '}';
    }*/

    @Override
    public String toString() {
        return "Job{" +
                "jobId=" + jobId +
                ", jobTitle='" + jobTitle + '\'' +
                ", jobDescription='" + jobDescription + '\'' +
                ", jobMinSalary=" + jobMinSalary +
                ", jobMaxSalary=" + jobMaxSalary +
                ", Location='" + Location + '\'' +
                ", company=" + (company != null ? company.getCompanyName() : "null") +
                '}';
    }

}
