package com.bredex.repository;

import com.bredex.loader.Loader;
import com.bredex.model.JobSeeker;
import org.springframework.data.repository.CrudRepository;

public interface JobSeekerRepository extends CrudRepository<JobSeeker, Long> {
}
