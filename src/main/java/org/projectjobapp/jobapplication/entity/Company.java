package org.projectjobapp.jobapplication.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

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
    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Job> jobs;

    @JsonIgnore
    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL )
    private List<Reviews> reviews;

    public Company() {
    }

    public Company(Long companyId, String companyName, String companyDescription, List<Job> jobs) {
        this.companyId = companyId;
        this.companyName = companyName;
        this.companyDescription = companyDescription;
        this.jobs = jobs;
    }

    public Company(Long companyId, String companyName, String companyDescription, List<Job> jobs, List<Reviews> reviews) {
        this.companyId = companyId;
        this.companyName = companyName;
        this.companyDescription = companyDescription;
        this.jobs = jobs;
        this.reviews = reviews;
    }

    public List<Reviews> getReviews() {
        return reviews;
    }

    public void setReviews(List<Reviews> reviews) {
        this.reviews = reviews;
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

    /*@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Company{");
        sb.append("companyId=").append(companyId);
        sb.append(", companyName='").append(companyName).append('\'');
        sb.append(", companyDescription='").append(companyDescription).append('\'');
        sb.append(", jobs=[");
        if (jobs != null) {
            for (Job job : jobs) {
                sb.append("{")
                        .append("jobId=").append(job.getJobId())
                        .append(", jobTitle='").append(job.getJobTitle()).append('\'')
                        .append(", jobDescription='").append(job.getJobDescription()).append('\'')
                        .append(", jobMinSalary=").append(job.getJobMinSalary())
                        .append(", jobMaxSalary=").append(job.getJobMaxSalary())
                        .append(", location='").append(job.getLocation()).append('\'')
                        .append("}");
            }
        }
        sb.append("]");
        sb.append('}');
        return sb.toString();
    }*/


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CompanyDTO{");
        sb.append("companyId=").append(companyId);
        sb.append(", companyName='").append(companyName).append('\'');
        sb.append(", companyDescription='").append(companyDescription).append('\'');
        sb.append(", jobs=[");
        if (jobs != null) {
            for (Job job : jobs) {
                sb.append("{")
                        .append("jobId=").append(job.getJobId())
                        .append(", jobTitle='").append(job.getJobTitle()).append('\'')
                        .append(", jobDescription='").append(job.getJobDescription()).append('\'')
                        .append(", jobMinSalary=").append(job.getJobMinSalary())
                        .append(", jobMaxSalary=").append(job.getJobMaxSalary())
                        .append(", location='").append(job.getLocation()).append('\'')
                        .append("}");
            }
        }
        sb.append("]");
        sb.append(", reviews=[");
        if (reviews != null) {
            for (Reviews review : reviews) {
                sb.append("{")
                        .append("reviewId=").append(review.getReviewId())
                        .append(", name='").append(review.getName()).append('\'')
                        .append(", description='").append(review.getDescription()).append('\'')
                        .append(", rating=").append(review.getRating())
                        .append("}");
            }
        } else {
            sb.append("null");
        }
        sb.append('}');
        return sb.toString();
    }


}
