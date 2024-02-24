package org.projectjobapp.jobapplication.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Job {
    @Id
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
}
