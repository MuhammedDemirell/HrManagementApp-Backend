package com.project.accountingProject.model.response;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.accountingProject.model.entity.ContactInfo;
import com.project.accountingProject.model.entity.JobInfo;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
public class EmployeeDto {

    private UUID id;

    private String name;

    private String surname;

    private String identityNumber;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @JsonProperty("birth-date")
    private LocalDate birthDate;

    private JobInfo jobInfo;

    private ContactInfo contactInfo;



}
