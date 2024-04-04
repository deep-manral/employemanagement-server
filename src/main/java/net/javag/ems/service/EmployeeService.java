package net.javag.ems.service;

import net.javag.ems.dto.EmployDto;

import java.util.List;

public interface EmployeeService {
    EmployDto createEmployee(EmployDto employDto);

    EmployDto getEmployeeById(Long  employeeId);

    List<EmployDto> getAllEmployees();

EmployDto updateEmployee(Long employeeId,EmployDto updatedEmployee);


void deleteEmployee(Long employeeId);

}
