package com.bredex.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Entity
@Data
@Builder
public class JobSeeker {

    @jakarta.persistence.Id
    @GeneratedValue
    @Column(updatable = false, nullable = false)
    Long Id;

    @Column
    @Length(max = 100)
    String name;

    @Column
    String email;

    public JobSeeker(Long id, String name, String email) {
        Id = id;
        this.name = name;
        this.email = email;
    }

    public JobSeeker() {
    }
}
