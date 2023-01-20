package com.bredex.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;


@Entity
@Data
@Builder
public class Employer {

    @Id
    @GeneratedValue
    @Column(updatable = false, nullable = false)
    Long Id;

    @Column
    @Length(max = 50)
    String jobName;

    @Column
    @Length(max = 50)
    String location;

    public Employer(){

    }

    public Employer(Long id, String jobName, String location) {
        Id = id;
        this.jobName = jobName;
        this.location = location;
    }
}
