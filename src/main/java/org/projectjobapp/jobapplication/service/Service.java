package org.projectjobapp.jobapplication.service;

import org.projectjobapp.jobapplication.dto.JobDTO;

import java.util.List;

public interface Service {
    public List<JobDTO> getAllJobs();
    public JobDTO getJobById(Long jobId);
    public JobDTO createJob(JobDTO jobDTO);
    public JobDTO updateJob(Long jobId, JobDTO jobDTO);
    public void deleteJob(Long jobId);
}
