package com.bredex.services;

import com.bredex.model.Employer;
import com.bredex.repository.EmployerRepository;
import com.bredex.validation.Validator;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployerServiceImpl implements EmployerService{

    Validator validator;
    EmployerRepository employerRepository;

    public EmployerServiceImpl(EmployerRepository employerRepository, Validator validator){

        this.employerRepository = employerRepository;
        this.validator = validator;
    }

    @Override
    public List<Employer> getEmployers() {
        List<Employer> employers = new ArrayList<>();
        employerRepository.findAll().forEach(employers::add);
        return employers;
    }

    @Override
    public Employer insertEmployer(Employer employer) throws Exception {
        if(!validator.StringLengthValidator(employer.getJobName(),50)){
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "too long name");
        }else if(!validator.StringLengthValidator(employer.getLocation(),50)) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "too long location name");
        }else
            {
                return employerRepository.save(employer);
            }
        }



    @Override
    public List<Employer> getJobByName(String name, String location) {
        List<Employer> employers = new ArrayList<>();
        if(validator.StringLengthValidator(name,50) && validator.StringLengthValidator(location,50)){
            employerRepository.findAll().forEach(
                    employer -> {
                        if (employer.getJobName().contains(name) && employer.getLocation().equals(location)) {
                            employers.add(employer);
                        }
                    }
            );
        }else {
        throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "too long name or location");
        }

        return employers;
    }
}
