package com.bredex.controller;


import com.bredex.model.Employer;
import com.bredex.model.JobSeeker;
import com.bredex.services.EmployerService;
import com.bredex.services.JobSeekerService;
import com.bredex.validation.Validator;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpStatusCodeException;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployerController {




    JobSeekerService jobSeekerService;
    EmployerService employerService;
    public EmployerController(EmployerService employerService, JobSeekerService jobSeekerService){
        this.employerService = employerService;
        this.jobSeekerService = jobSeekerService;
    }




    @GetMapping("/allEmp")
    public ResponseEntity<List<Employer>> getAllEmployers(){

        List<Employer> employers = employerService.getEmployers();


        return new ResponseEntity<>(employers, HttpStatus.OK);

    }


    @GetMapping("/allJobSeekers")
    public ResponseEntity<List<JobSeeker>> getAllJobSeeker(){
        List<JobSeeker> jobSeekers = jobSeekerService.getJobSeekers();
        return new ResponseEntity<>(jobSeekers, HttpStatus.OK);
    }

    @PostMapping("/position")
    public ResponseEntity<Employer> saveEmployer(@RequestBody Employer employer) throws Exception {
        HttpHeaders httpHeaders = new HttpHeaders();
        Employer employer1 = null;
        try{
            employer1 = employerService.insertEmployer(employer);
            httpHeaders.add("emp", "emp" + employer1.getId().toString());
        }catch (HttpClientErrorException e){
            System.out.println(e.toString());
        }




        return new ResponseEntity<>(employer1, httpHeaders, HttpStatus.CREATED);
    }

    @PostMapping("/client")
    public ResponseEntity<JobSeeker> saveJobSeeker(@RequestBody JobSeeker jobSeeker) {


        HttpHeaders httpHeaders = new HttpHeaders();
        JobSeeker jobSeeker1 = null;
        try{

            jobSeeker1 = jobSeekerService.insertJobSeekers(jobSeeker);
            httpHeaders.add("jobS", "jobSeeker" + jobSeeker1.getId().toString());


        }catch (HttpClientErrorException e){
            System.out.println(e.toString());
        }
        return new ResponseEntity<>(jobSeeker1, httpHeaders, HttpStatus.CREATED);
    }

    @GetMapping({"/position/search/{pos}/{loc}"})
    public ResponseEntity<List<Employer>> getTodo(@PathVariable String pos, @PathVariable String loc) {
        return new ResponseEntity<>(employerService.getJobByName(pos, loc), HttpStatus.OK);
    }


}
