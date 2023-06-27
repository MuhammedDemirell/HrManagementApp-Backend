package com.project.accountingProject.model.mapper;


import com.project.accountingProject.model.entity.Expense;
import com.project.accountingProject.model.request.CreateExpenseRequest;
import com.project.accountingProject.model.response.ExpenseDto;
import org.mapstruct.Mapper;

@Mapper(implementationName = "ExpenseMapperImpl", componentModel = "spring", unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public interface ExpenseMapper {
    ExpenseDto toExpenseDto(Expense expense);

    Expense toExpense(CreateExpenseRequest expense);


}
