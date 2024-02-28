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

import static org.junit.jupiter.api.Assertions.*;


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
    }

    @Test
    void getJobById() {
    }

    @Test
    void createJob() {
    }

    @Test
    void updateJob() {
    }

    @Test
    void deleteJob() {
    }
}