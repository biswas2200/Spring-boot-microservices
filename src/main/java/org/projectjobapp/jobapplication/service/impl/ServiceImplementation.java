package org.projectjobapp.jobapplication.service.impl;

import org.projectjobapp.jobapplication.dto.JobDTO;
import org.projectjobapp.jobapplication.entity.Job;
import org.projectjobapp.jobapplication.repository.JobRepository;
import org.projectjobapp.jobapplication.service.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@org.springframework.stereotype.Service
public class ServiceImplementation implements Service {

    final JobRepository jobRepository;

    @Autowired
    public ServiceImplementation(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    public JobDTO mapToDTOJob(Job job){
        if (job == null)
            return null;
        JobDTO jobDTO = new JobDTO();
        jobDTO.setJobId(job.getJobId());
        jobDTO.setJobTitle(job.getJobTitle());
        jobDTO.setJobDescription(job.getJobDescription());
        jobDTO.setJobMaxSalary(job.getJobMaxSalary());
        jobDTO.setJobMinSalary(job.getJobMinSalary());
        jobDTO.setLocation(job.getLocation());

        return jobDTO;
    }

    public Job mapToEntityJob(JobDTO jobDTO){
        if (jobDTO == null)
            return null;
        Job job = new Job();
        job.setJobId(jobDTO.getJobId());
        job.setJobTitle(jobDTO.getJobTitle());
        job.setJobDescription(jobDTO.getJobDescription());
        job.setJobMaxSalary(jobDTO.getJobMaxSalary());
        job.setJobMinSalary(jobDTO.getJobMinSalary());
        job.setLocation(jobDTO.getLocation());

        return job;
    }

    @Override
    public List<JobDTO> getAllJobs() {
        List<Job> jobs = jobRepository.findAll();
        return jobs.stream()
                .map(this::mapToDTOJob)
                .collect(Collectors.toList());
    }

    @Override
    public JobDTO getJobById(Long jobId) {
        Optional<Job> optionalJob = jobRepository.findById(jobId);
        return optionalJob.map(this::mapToDTOJob)
                .orElse(null);
    }

    @Override
    public JobDTO createJob(JobDTO jobDTO) {
        Job job = mapToEntityJob(jobDTO);
        Job saveJob = jobRepository.save(job);
        return mapToDTOJob(saveJob);
    }

    @Override
    public JobDTO updateJob(Long jobId, JobDTO jobDTO) {
        Job existingJob = jobRepository.findById(jobId).orElse(null);
        if (existingJob != null){
            existingJob.setJobTitle(jobDTO.getJobTitle());
            existingJob.setJobDescription(jobDTO.getJobDescription());
            existingJob.setJobMaxSalary(jobDTO.getJobMaxSalary());
            existingJob.setJobMinSalary(jobDTO.getJobMinSalary());
            existingJob.setLocation(jobDTO.getLocation());
            Job updateJob = jobRepository.save(existingJob);
            return mapToDTOJob(updateJob);
        }
        return null;
    }

    @Override
    public void deleteJob(Long jobId) {
        jobRepository.deleteById(jobId);
    }

}
