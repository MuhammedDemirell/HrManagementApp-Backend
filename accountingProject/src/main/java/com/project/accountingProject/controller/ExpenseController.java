package com.project.accountingProject.controller;

import com.project.accountingProject.model.entity.Expense;
import com.project.accountingProject.model.request.CreateExpenseRequest;
import com.project.accountingProject.model.request.UpdateExpenseUpdate;
import com.project.accountingProject.model.response.ExpenseDto;
import com.project.accountingProject.service.command.ExpenseComamandService;
import com.project.accountingProject.service.query.ExpenseQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin("http://localhost:3000")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/expenses")
public class ExpenseController {

    private final ExpenseQueryService expenseQueryService;
    private final ExpenseComamandService expenseComamandService;


    @GetMapping
    public List<ExpenseDto> getAllExpenses() {
        return expenseQueryService.getAllExpenses();
    }

    @PostMapping("/create")
    public Expense createExpense(@Valid @RequestBody CreateExpenseRequest request) {
        return expenseComamandService.createExpense(request);
    }

    @GetMapping("/edit/{id}")
    public UpdateExpenseUpdate getEditExpense(@PathVariable String identityNumber, @RequestBody UpdateExpenseUpdate request) {

        ExpenseDto expenseDto = expenseQueryService.getExpenseId(identityNumber, request);
        UpdateExpenseUpdate updateExpenseUpdate = new UpdateExpenseUpdate();

        updateExpenseUpdate.setId(expenseDto.getId());
        updateExpenseUpdate.setExpenseAmount(expenseDto.getExpenseAmount());
        updateExpenseUpdate.setVat(expenseDto.getVat());
        updateExpenseUpdate.setExpenseDate(expenseDto.getExpenseDate());
        updateExpenseUpdate.setExpenseType(expenseDto.getExpenseType());
        updateExpenseUpdate.setDetails(expenseDto.getDetails());
        updateExpenseUpdate.setEmployeeId(expenseDto.getEmployee().getId());

        return updateExpenseUpdate;
    }

    @PostMapping("/{id}")
    public Expense editExpense(@PathVariable String identityNumber, @RequestBody UpdateExpenseUpdate request) {

        Expense expense = expenseQueryService.updateExpense(identityNumber, request);
        return expense;
    }

    @DeleteMapping("/{id}")
    public void deleteExpense(@PathVariable String identityNumber) {

        expenseQueryService.deleteByIdExpense(identityNumber);
    }

}
