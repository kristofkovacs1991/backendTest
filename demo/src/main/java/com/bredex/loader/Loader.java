package com.bredex.loader;

import com.bredex.model.Employer;
import com.bredex.model.JobSeeker;
import com.bredex.repository.EmployerRepository;
import com.bredex.repository.JobSeekerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class Loader implements CommandLineRunner {

    public final EmployerRepository employerRepository;
public final JobSeekerRepository jobSeekerRepository;

    public Loader(EmployerRepository employerRepository, JobSeekerRepository jobSeekerRepository) {
        this.employerRepository = employerRepository;
        this.jobSeekerRepository = jobSeekerRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        loadEmployers();
    }

    private void loadEmployers() {

        if(employerRepository.count()== 0){
            employerRepository.save(
                    Employer.builder()
                            .jobName("Application Engineer")
                            .location("Budapest")
                            .build()
            );
            System.out.println("success");
        }

        if(jobSeekerRepository.count()==0){
            jobSeekerRepository.save(
                    JobSeeker.builder()
                            .name("Kata")
                            .email("pelda@pelda.hu")
                            .build()
            );
        }
    }
}
