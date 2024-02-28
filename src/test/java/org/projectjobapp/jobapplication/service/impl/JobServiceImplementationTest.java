package org.projectjobapp.jobapplication.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.projectjobapp.jobapplication.dto.JobDTO;
import org.projectjobapp.jobapplication.entity.Job;
import org.projectjobapp.jobapplication.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@RunWith(SpringRunner.class)
@SpringBootTest
class JobServiceImplementationTest {

    @Autowired
    private JobServiceImplementation jobServiceImplementation;

    @MockBean
    private JobRepository jobRepository;

    @Test
    void mapToDTOJob() {
        Job job = new Job();
        job.setJobId(10L);
        job.setJobTitle("BackEnd Engineer");
        job.setJobDescription("Software Engineer");
        job.setJobMaxSalary(25000);
        job.setJobMinSalary(15000);
        job.setLocation("Bangalore");

        JobDTO jobDTO = jobServiceImplementation.mapToDTOJob(job);

        assertEquals(jobDTO.getJobId(), job.getJobId());
        assertEquals(jobDTO.getJobTitle(), job.getJobTitle());
        assertEquals(jobDTO.getJobDescription(), job.getJobDescription());
        assertEquals(jobDTO.getJobMinSalary(), job.getJobMinSalary());
        assertEquals(jobDTO.getJobMaxSalary(), job.getJobMaxSalary());
        assertEquals(jobDTO.getLocation(), job.getLocation());
    }

    @Test
    void mapToEntityJob() {
        JobDTO jobDTO = new JobDTO();
        jobDTO.setJobId(10L);
        jobDTO.setJobTitle("BackEnd Engineer");
        jobDTO.setJobDescription("Software Engineer");
        jobDTO.setJobMaxSalary(30000);
        jobDTO.setJobMinSalary(25000);
        jobDTO.setLocation("Hyderabad");

        Job job = jobServiceImplementation.mapToEntityJob(jobDTO);

        assertEquals(job.getJobId(),jobDTO.getJobId());
        assertEquals(job.getJobTitle(), jobDTO.getJobTitle());
        assertEquals(job.getJobDescription(), jobDTO.getJobDescription());
        assertEquals(job.getJobMinSalary(), jobDTO.getJobMinSalary());
        assertEquals(job.getJobMaxSalary(), jobDTO.getJobMaxSalary());
        assertEquals(job.getLocation(), jobDTO.getLocation());
    }

    @Test
    void getAllJobs() {
        List<Job> jobList = Arrays.asList(
                new Job(10L, "BackEngineer", "Software Engineer", 12000, 18000, "Bangalore"),
                new Job(11L, "FrontEnd Engineer", "Software Engineer", 18000, 25000, "Kolkata")
        );

        when(jobRepository.findAll()).thenReturn(jobList);
        List<JobDTO> jobDTOS = jobServiceImplementation.getAllJobs();
        assertEquals(2,jobDTOS.size());
    }

    @Test
    void getJobById() {
        Optional<Job> optionalJob =
                Optional.of(new Job(10L, "BackEnd Engineer", "Software Engineer", 12000, 18000, "Bangalore"));
        when(jobRepository.findById(10L)).thenReturn(optionalJob);

        JobDTO jobDTO = jobServiceImplementation.getJobById(10L);

        assertNotNull(jobDTO);

        assertEquals(10L , jobDTO.getJobId());
        assertEquals("BackEnd Engineer", jobDTO.getJobTitle());
        assertEquals("Software Engineer", jobDTO.getJobDescription());
        assertEquals(12000, jobDTO.getJobMinSalary());
        assertEquals(18000, jobDTO.getJobMaxSalary());
        assertEquals("Bangalore", jobDTO.getLocation());

    }

    @Test
    void createJob() {
        JobDTO jobDTO = new JobDTO();
        jobDTO.setJobId(10L);
        jobDTO.setJobTitle("BackEnd Engineer");
        jobDTO.setJobDescription("Software Engineer");
        jobDTO.setJobMaxSalary(30000);
        jobDTO.setJobMinSalary(20000);
        jobDTO.setLocation("Bangalore");

        Job savedJobEntity = new Job();
        savedJobEntity.setJobId(10L);
        savedJobEntity.setJobTitle("BackEnd Engineer");
        savedJobEntity.setJobDescription("Software Engineer");
        savedJobEntity.setJobMaxSalary(30000);
        savedJobEntity.setJobMinSalary(20000);
        savedJobEntity.setLocation("Bangalore");

        when(jobRepository.save(any(Job.class))).thenReturn(savedJobEntity);
    }

    @Test
    void updateJob() {
        Long jobId = 10L;

        Job existingJob = new Job();
        existingJob.setJobId(jobId);
        existingJob.setJobTitle("DevOps Engineer");
        existingJob.setJobDescription("Software Engineer");
        existingJob.setJobMinSalary(19000);
        existingJob.setJobMaxSalary(28000);
        existingJob.setLocation("Delhi");

        JobDTO updateJobDTO = new JobDTO();
        updateJobDTO.setJobId(jobId);
        updateJobDTO.setJobTitle("DevOps Engineer");
        updateJobDTO.setJobDescription("Cloud Engineer");
        updateJobDTO.setJobMinSalary(18000);
        updateJobDTO.setJobMaxSalary(38000);
        updateJobDTO.setLocation("Pune");

        when(jobRepository.findById(jobId)).thenReturn(Optional.of(existingJob));
        when(jobRepository.save(existingJob)).thenReturn(existingJob);

        JobDTO updatedJob = jobServiceImplementation.updateJob(jobId, updateJobDTO);

        verify(jobRepository).findById(jobId);
        verify(jobRepository).save(existingJob);

        assertNotNull(updatedJob);
        assertEquals(updateJobDTO.getJobId(), updatedJob.getJobId());
        assertEquals(updateJobDTO.getJobTitle(), updatedJob.getJobTitle());
        assertEquals(updateJobDTO.getJobDescription(), updatedJob.getJobDescription());
        assertEquals(updateJobDTO.getJobMinSalary(), updatedJob.getJobMinSalary());
        assertEquals(updateJobDTO.getJobMaxSalary(), updatedJob.getJobMaxSalary());
        assertEquals(updateJobDTO.getLocation(), updatedJob.getLocation());

    }

    @Test
    void deleteJob() {
        Long jobId = 10L;
        jobServiceImplementation.deleteJob(jobId);

        verify(jobRepository).deleteById(jobId);
    }
}