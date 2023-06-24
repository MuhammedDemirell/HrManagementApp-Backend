package com.project.accountingProject.controller;


import com.project.accountingProject.model.response.EmployeeDto;
import com.project.accountingProject.service.EmployeeService;
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
    public ResponseEntity<EmployeeDto> createEmployee(@Valid @RequestBody EmployeeDto employee) {
        return ResponseEntity.ok(employeeService.createEmployee(employee));
    }


    @GetMapping("/update/{id}")
    public ResponseEntity<EmployeeDto> getEditEmployeePage(@PathVariable @RequestParam("id") String identityNumber) {
        EmployeeDto employeeDto = employeeService.getEmployeeById(identityNumber);
        return ResponseEntity.ok(employeeDto);

    }

    @PostMapping("/update/{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable String identityNumber) {
        EmployeeDto employeeDto = employeeService.getEmployeeById(identityNumber);
        EmployeeDto employeeDto1 = new EmployeeDto();
        employeeDto1.setId(employeeDto.getId());
        employeeDto1.setName(employeeDto.getName());
        employeeDto1.setSurname(employeeDto.getSurname());
        employeeDto1.setIdentityNumber(employeeDto.getIdentityNumber());
        employeeDto1.setJobInfo(employeeDto.getJobInfo());
        employeeDto1.setContactInfo(employeeDto.getContactInfo());
        employeeDto1.setBirthDate(employeeDto.getBirthDate());

        return ResponseEntity.ok(employeeDto);

    }

    @Transactional
    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteEmployee(@PathVariable @RequestParam("id") String identityNumber) {
        employeeService.deleteEmployee(identityNumber);
    }
}
