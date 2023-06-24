package com.project.accountingProject.model.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@Entity
public class Employee {

    @Id
    @GeneratedValue
    @Column(length = 36)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname;

    @Column(nullable = false, unique = true)
    private String identityNumber;

    @Column(nullable = false)
    private LocalDate birthDate;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private JobInfo jobInfo;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private ContactInfo contactInfo;


}
