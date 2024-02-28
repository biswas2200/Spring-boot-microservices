package org.projectjobapp.jobapplication.controller;

import org.projectjobapp.jobapplication.dto.JobDTO;
import org.projectjobapp.jobapplication.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class JobController {

    public JobService jobService;

    @Autowired
    public JobController(JobService jobService) {
        this.jobService = jobService;
    }
    @GetMapping("/get")
    public ResponseEntity<List<JobDTO>> getAllJobs() {
        List<JobDTO> jobDTOS = jobService.getAllJobs();
        return new ResponseEntity<>(jobDTOS, HttpStatus.OK);
    }
    @GetMapping("/get/{jobId}")
    public ResponseEntity<JobDTO> getJobJobById(@PathVariable Long jobId) {
        JobDTO jobDTO = jobService.getJobById(jobId);
        return jobDTO != null ? new ResponseEntity<>(jobDTO, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/create")
    public ResponseEntity<JobDTO> createJob(@RequestBody JobDTO jobDTO) {
        JobDTO createJob = jobService.createJob(jobDTO);
        return new ResponseEntity<>(createJob, HttpStatus.OK);
    }

    @PutMapping("/update/{jobId}")
    public ResponseEntity<JobDTO> updateJob(@PathVariable Long jobId, @RequestBody JobDTO jobDTO) {
        JobDTO updateJob = jobService.updateJob(jobId, jobDTO);
        return jobDTO != null ? new ResponseEntity<>(updateJob, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/get/{jobId}")
    public ResponseEntity<Void> deleteJob(@PathVariable Long jobId) {
        jobService.deleteJob(jobId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
