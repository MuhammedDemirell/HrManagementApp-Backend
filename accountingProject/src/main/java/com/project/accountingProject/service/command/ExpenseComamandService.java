package com.project.accountingProject.service.command;


import com.project.accountingProject.model.entity.Employee;
import com.project.accountingProject.model.entity.Expense;
import com.project.accountingProject.model.request.CreateExpenseRequest;
import com.project.accountingProject.repository.EmployeeRepository;
import com.project.accountingProject.repository.ExpenseRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ExpenseComamandService {

    private final ExpenseRepository expenseRepository;
    private final EmployeeRepository employeeRepository;

    @SneakyThrows
    @Transactional
    public Expense createExpense(CreateExpenseRequest request) {

        Employee employee = employeeRepository.findById(request.getEmployeeId())
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        Expense expense = new Expense();
        expense.setExpenseAmount(request.getExpenseAmount());
        expense.setVat(request.getVat());
        expense.setExpenseDate(request.getExpenseDate());
        expense.setExpenseType(request.getExpenseType());
        expense.setDetails(request.getDetails());
        expense.setId(request.getId());
        expense.setEmployee(employee);


        return expenseRepository.save(expense);


    }
}