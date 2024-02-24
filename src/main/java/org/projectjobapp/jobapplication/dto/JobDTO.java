package org.projectjobapp.jobapplication.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobDTO {
    private Long jobId;
    private String jobTitle;
    private String jobDescription;
    private Integer jobMinSalary;
    private Integer jobMaxSalary;
    private String Location;
}
