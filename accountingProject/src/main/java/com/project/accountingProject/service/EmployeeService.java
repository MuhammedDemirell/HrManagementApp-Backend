package com.project.accountingProject.service;

import com.project.accountingProject.model.entity.Employee;
import com.project.accountingProject.model.mapper.EmployeeMapper;
import com.project.accountingProject.model.response.EmployeeDto;
import com.project.accountingProject.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Slf4j
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;


    @Transactional(readOnly = true)
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employeeList = employeeRepository.findAll();

        return employeeList.stream()
                .map(employeeMapper::toEmployeeDto)
                .collect(Collectors.toList());
        //       List<EmployeeDto> employeeDtoList= new ArrayList<>();
//
//        EmployeeDto employeeDto = new EmployeeDto();
//        employeeDto.setId(UUID.randomUUID());
//        employeeDto.setName("Muhammed");
//        employeeDto.setSurname("Demirel");
//        employeeDto.setBirthDate(LocalDate.parse("1995-01-01"));
//        employeeDto.setIdentityNumber("12345678910");
//
//        EmployeeDto employeeDto1 = new EmployeeDto();
//        employeeDto1.setId(UUID.randomUUID());
//        employeeDto1.setName("Muhammed");
//        employeeDto1.setSurname("Demirel");
//        employeeDto1.setBirthDate(LocalDate.parse("1995-01-01"));
//        employeeDto1.setIdentityNumber("12345678910");
//
//        employeeDtoList.add(employeeDto);
//        employeeDtoList.add(employeeDto1);
//
//        return employeeDtoList;

    }

    public EmployeeDto createEmployee(EmployeeDto employee) {
        Employee createEmployee = employeeRepository.save(employeeMapper.toEmployee(employee));
        return employeeMapper.toEmployeeDto(createEmployee);
    }

    public EmployeeDto getEmployeeById(String identityNumber) {
        Employee employee = employeeRepository.findByEmployeeId(identityNumber).orElseThrow();
        return employeeMapper.toEmployeeDto(employee);
    }

//    public EmployeeDto updateEmployee(UUID id) {
//        Employee employee = employeeRepository.findById(id).orElseThrow();
//        return employeeMapper.toEmployeeDto(employee);
//
//    }


    public void deleteEmployee(String id) {
        employeeRepository.deleteByIdEmployee(id);
    }

}
