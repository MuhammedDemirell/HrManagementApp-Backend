package com.project.accountingProject.model.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.accountingProject.model.entity.enums.ExpenseType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
public class UpdateExpenseUpdate {

    private UUID id;

    private int expenseAmount;

    private int vat;

    @Enumerated(value = EnumType.STRING)
    private ExpenseType expenseType;

    private String details;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @JsonProperty("expense-date")
    private LocalDate expenseDate;

    private UUID employeeId;

}
