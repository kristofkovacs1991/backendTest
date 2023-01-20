package com.bredex.services;

import com.bredex.model.Employer;

import java.util.List;

public interface EmployerService {

    List<Employer> getEmployers();

    Employer insertEmployer(Employer employer) throws Exception;

    List<Employer> getJobByName(String name, String location);
}
