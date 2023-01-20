package com.bredex.services;

import com.bredex.model.Employer;
import com.bredex.model.JobSeeker;
import com.bredex.repository.JobSeekerRepository;
import com.bredex.validation.Validator;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobSeekerImpl implements JobSeekerService{

    JobSeekerRepository jobSeekerRepository;

    Validator validator;

    public JobSeekerImpl(JobSeekerRepository jobSeekerRepository, Validator validator) {

        this.jobSeekerRepository = jobSeekerRepository;
        this.validator = validator;
    }

    @Override
    public List<JobSeeker> getJobSeekers() {
        List<JobSeeker> jobSeekers = new ArrayList<>();
        jobSeekerRepository.findAll().forEach(jobSeekers::add);
        return jobSeekers;
    }

    @Override
    public JobSeeker insertJobSeekers(JobSeeker jobSeeker) {
        if(validator.StringLengthValidator(jobSeeker.getName(),100) == false ){
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "too long name");
        }else if(validator.EmailValidator(jobSeeker.getEmail()) == false){
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "not valid email address!");
        }else
        {
            return jobSeekerRepository.save(jobSeeker);
        }

    }
}
