package com.project.accountingProject.repository;

import com.project.accountingProject.model.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ExpenseRepository extends JpaRepository<Expense, UUID> {
    @Query("select x from Expense x join fetch x.employee e")
    List<Expense> findAllExpenses();

    @Modifying
    @Query("DELETE FROM Employee e WHERE e.identityNumber = :identityNumber")
    void deleteByIdEmployee(String identityNumber);

    @Query("select x from Expense x join fetch x.employee e where e.identityNumber = :identityNumber")
    List<Expense> findAllExpensesByIdEmployee(String identityNumber);

}
