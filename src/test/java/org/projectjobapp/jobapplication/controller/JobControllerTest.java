package org.projectjobapp.jobapplication.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.projectjobapp.jobapplication.dto.JobDTO;
import org.projectjobapp.jobapplication.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(JobController.class)
class JobControllerTest {

    @Autowired
    WebApplicationContext webApplicationContext;

    @Autowired
    ObjectMapper objectMapper;

    @InjectMocks
    private JobController jobController;

    @MockBean
    private JobService jobService;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(jobController).build();
    }

    @Test
    void getAllJobs() throws Exception {
        List<JobDTO> jobDTOS = Arrays.asList(
                new JobDTO(1L, "BackEnd Engineer", "Software Engineer", 18000, 20000, "Bangalore"),
                new JobDTO(2L, "FrontEnd Engineer", "Software Engineer", 18000, 20000, "Bangalore"),
                new JobDTO(3L, "Human Resource", "Finance ", 18000, 20000, "Bangalore")
        );
        when(jobService.getAllJobs()).thenReturn(jobDTOS);
        mockMvc.perform(get("/api/get")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void getJobJobById() throws Exception {
        JobDTO jobDTO = new JobDTO(101L, "BackEnd Engineer", "Software Engineer", 18000, 25000, "Bangalore");
        when(jobService.getJobById(101L)).thenReturn(jobDTO);
        mockMvc.perform(get("/api/get/101")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void createJob() throws Exception {
        JobDTO jobDTO = new JobDTO(10L, "BackEnd Engineer", "Software Enginee", 15000, 20000, "Delhi");
        when(jobService.createJob(any())).thenReturn(jobDTO);
        mockMvc.perform(post("/api/create")
                .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(jobDTO)))
                .andExpect(status().isOk());
    }

    @Test
    void updateJob() throws Exception {
        JobDTO jobDTO = new JobDTO(10L, "BackEnd Engineer", "Software Engineer", 15000, 20000, "Delhi");
        JobDTO updatedJobDTO = new JobDTO(10L, "BackEnd Engineer", "Software Engineer", 15000, 20000, "Bangalore");

        when(jobService.updateJob(Mockito.eq(10L), Mockito.any())).thenReturn(updatedJobDTO);
        mockMvc.perform(put("/api/update/10")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(jobDTO)))
                .andExpect(status().isOk());
    }

    @Test
    void deleteJob() throws Exception {
        JobDTO jobDTO = new JobDTO(10L, "BackEnd Engineer", "Software Engineer", 15000, 20000, "Delhi");
        mockMvc.perform(delete("/api/get/10"))
                .andExpect(status().isOk());
        Mockito.verify(jobService).deleteJob(jobDTO.getJobId());
    }
}