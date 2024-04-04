package net.javag.ems.mapper;

import net.javag.ems.dto.EmployDto;
import net.javag.ems.entity.Employee;

public class EmployeMapper {
    public static EmployDto mapToEmployeeDto(Employee employee){
        return new EmployDto(
employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail()
        );
    }

    public static Employee mapToEmployee(EmployDto employDto){
        return new Employee(
                employDto.getId(),
                employDto.getFirstName(),
                employDto.getLastName(),
                employDto.getEmail()
        );
    }

}
