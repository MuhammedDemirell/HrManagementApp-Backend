package com.project.accountingProject.service.query;


import com.project.accountingProject.model.entity.Expense;
import com.project.accountingProject.model.mapper.ExpenseMapper;
import com.project.accountingProject.model.request.UpdateEmployeeRequest;
import com.project.accountingProject.model.request.UpdateExpenseUpdate;
import com.project.accountingProject.model.response.ExpenseDto;
import com.project.accountingProject.repository.ExpenseRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Slf4j
public class ExpenseQueryService {

    private final ExpenseRepository expenseRepository;
    private final ExpenseMapper expenseMapper;

    public ExpenseDto getExpenseId(String identityNumber, UpdateExpenseUpdate request) {
        Expense expense = (Expense) expenseRepository.findAllExpensesByIdEmployee(identityNumber);
        return expenseMapper.toExpenseDto(expense);

    }

    @Transactional(readOnly = true)
    public List<ExpenseDto> getAllExpenses() {
        List<Expense> expenseList = expenseRepository.findAllExpenses();

        return expenseList.stream()
                .map(expenseMapper::toExpenseDto)
                .collect(Collectors.toList());
    }


    public Expense editExpense(@PathVariable String identityNumber, UpdateEmployeeRequest request) {
        Expense expense = (Expense) expenseRepository.findAllExpensesByIdEmployee(identityNumber);
        return expenseRepository.save(expense);


    }


    public void deleteByIdExpense(String identityNumber) {
        expenseRepository.deleteById(UUID.fromString(identityNumber));
    }

    public Expense updateExpense(String identityNumber, UpdateExpenseUpdate request) {
        Expense expense = (Expense) expenseRepository.findAllExpensesByIdEmployee(identityNumber);
        expense.setExpenseAmount(request.getExpenseAmount());
        expense.setVat(request.getVat());
        expense.setExpenseDate(request.getExpenseDate());
        expense.setExpenseType(request.getExpenseType());
        expense.setDetails(request.getDetails());
        expense.setId(request.getId());
        return expenseRepository.save(expense);
    }
}
