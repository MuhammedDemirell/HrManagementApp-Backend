package com.project.accountingProject.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.accountingProject.model.entity.enums.Department;
import com.project.accountingProject.model.entity.enums.Level;
import com.project.accountingProject.model.entity.enums.Position;
import com.project.accountingProject.model.entity.enums.WorkType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
public class JobInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Department department;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Level level;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Position position;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private WorkType workType;

    @Column(nullable = false)
    @JsonFormat(pattern = "dd/MM/yyyy")
    @JsonProperty("start-date")
    private LocalDate startDate;

    @Column(nullable = false)
    private int salary;

}
