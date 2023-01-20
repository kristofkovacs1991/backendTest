package com.bredex.services;

import com.bredex.model.Employer;
import com.bredex.model.JobSeeker;

import java.util.List;

public interface JobSeekerService {

    List<JobSeeker> getJobSeekers();

    JobSeeker insertJobSeekers(JobSeeker jobSeeker);

}
