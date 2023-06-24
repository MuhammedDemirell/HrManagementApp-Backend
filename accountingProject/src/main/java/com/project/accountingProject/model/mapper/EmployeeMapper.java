package com.project.accountingProject.model.mapper;

import com.project.accountingProject.model.entity.Employee;
import com.project.accountingProject.model.response.EmployeeDto;
import org.mapstruct.Mapper;

@Mapper(implementationName = "EmployeeMapperImpl", componentModel = "spring", unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public interface EmployeeMapper {

    EmployeeDto toEmployeeDto(Employee employee);

    Employee toEmployee(EmployeeDto employeeDto);

}
