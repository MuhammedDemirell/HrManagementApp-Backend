package com.project.accountingProject.controller;


import com.project.accountingProject.model.entity.Employee;
import com.project.accountingProject.model.request.CreateEmployeeRequest;
import com.project.accountingProject.model.request.UpdateEmployeeRequest;
import com.project.accountingProject.model.response.EmployeeDto;
import com.project.accountingProject.service.query.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;


@CrossOrigin("http://localhost:3000")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }


    @PostMapping("/create")
    public ResponseEntity<Employee> createEmployee(@Valid @RequestBody CreateEmployeeRequest request) {
        return ResponseEntity.ok(employeeService.createEmployee(request));
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable String id) {
        Employee employee = employeeService.getEmployee(id);
        if (employee != null) {
            return ResponseEntity.ok(employee);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable @RequestParam("id") String identityNumber, @RequestBody UpdateEmployeeRequest request) {
        Employee employeeDto = employeeService.getEmployeeUpdate(request, identityNumber);
        return ResponseEntity.ok(employeeDto);

    }

    @Transactional
    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteEmployee(@PathVariable @RequestParam("id") String identityNumber) {
        employeeService.deleteEmployee(identityNumber);
    }
}
