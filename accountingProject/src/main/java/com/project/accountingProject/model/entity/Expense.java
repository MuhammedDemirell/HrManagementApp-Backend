package com.project.accountingProject.model.entity;

import com.project.accountingProject.model.entity.enums.ExpenseType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Getter
@Setter
public class Expense {

    @Id
    @GeneratedValue
    @Column(length = 36)
    private UUID id;

    @Column(nullable = false)
    private int expenseAmount;

    @Column(nullable = false)
    private int vat; //KDV

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private ExpenseType expenseType;

    @Column(nullable = false)
    private String details;

    @Column(nullable = false)
    private LocalDate expenseDate;

    @JoinColumn(nullable = false)
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    private Employee employee;


}
