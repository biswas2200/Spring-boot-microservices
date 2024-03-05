package org.projectjobapp.jobapplication.dto;

import java.util.List;

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


   /* @Override
    public String toString() {
        return "CompanyDTO{" +
                "companyId=" + companyId +
                ", companyName='" + companyName + '\'' +
                ", companyDescription='" + companyDescription + '\'' +
                ", jobs=" + jobs +
                '}';
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
            for (JobDTO job : jobs) {
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
    }

}
