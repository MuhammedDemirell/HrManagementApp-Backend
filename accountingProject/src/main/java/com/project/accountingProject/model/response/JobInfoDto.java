package com.project.accountingProject.model.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.accountingProject.model.entity.enums.Department;
import com.project.accountingProject.model.entity.enums.Level;
import com.project.accountingProject.model.entity.enums.Position;
import com.project.accountingProject.model.entity.enums.WorkType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter

public class JobInfoDto {

    private Long id;

    private Department department;

    private Level level;

    private Position position;

    private WorkType workType;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @JsonProperty("start-date")
    private LocalDate startDate;

    private int salary;


}
