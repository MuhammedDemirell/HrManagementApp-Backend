package com.project.accountingProject.repository;


import com.project.accountingProject.model.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface EmployeeRepository extends JpaRepository<Employee, UUID> {

    @Query("SELECT e FROM Employee e WHERE e.identityNumber = :identityNumber")
    Optional<Employee> findByEmployeeId(String identityNumber);

    @Modifying
    @Query("DELETE FROM Employee e WHERE e.identityNumber = :identityNumber")
    void deleteByIdEmployee(String identityNumber);







}
