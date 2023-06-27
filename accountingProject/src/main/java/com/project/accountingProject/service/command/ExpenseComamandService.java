package com.project.accountingProject.service.command;


import com.project.accountingProject.model.entity.Expense;
import com.project.accountingProject.model.request.CreateExpenseRequest;
import com.project.accountingProject.repository.ExpenseRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ExpenseComamandService {

    private final ExpenseRepository expenseRepository;

    @SneakyThrows
    @Transactional
    public Expense createExpense(CreateExpenseRequest request) {

        if (request.getId() != null) request.setId(request.getId());

        Expense expense = new Expense();
        expense.setExpenseAmount(request.getExpenseAmount());
        expense.setVat(request.getVat());
        expense.setExpenseDate(request.getExpenseDate());
        expense.setExpenseType(request.getExpenseType());
        expense.setDetails(request.getDetails());
        expense.setId(request.getId());


        return expenseRepository.save(expense);


    }
}