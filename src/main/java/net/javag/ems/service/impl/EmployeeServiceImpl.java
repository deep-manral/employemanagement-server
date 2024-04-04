package net.javag.ems.service.impl;

import lombok.AllArgsConstructor;
import net.javag.ems.dto.EmployDto;
import net.javag.ems.entity.Employee;
import net.javag.ems.exception.ResourceNotFoundException;
import net.javag.ems.mapper.EmployeMapper;
import net.javag.ems.repository.EmployRepository;
import net.javag.ems.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployRepository employRepository;
    @Override
    public EmployDto createEmployee(EmployDto employDto) {
        Employee employee= EmployeMapper.mapToEmployee(employDto);
       Employee savedEmployee= employRepository.save(employee);

        return EmployeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployDto getEmployeeById(Long employeeId) {
  Employee employee=employRepository.findById(employeeId)
          .orElseThrow(()->new RuntimeException("Employee id not found:"+employeeId));
        return EmployeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployDto> getAllEmployees() {
       List<Employee>employees= employRepository.findAll();
       return employees.stream().map((employee)->EmployeMapper.mapToEmployeeDto(employee)).collect(Collectors.toList());



    }

    @Override
    public EmployDto updateEmployee(Long employeeId, EmployDto updatedEmployee) {
      Employee employee=  employRepository.findById(employeeId).orElseThrow(()->new ResourceNotFoundException("Employee not exists with given id"+employeeId));

      employee.setFirstName(updatedEmployee.getFirstName());
      employee.setLastName(updatedEmployee.getLastName());
      employee.setEmail(updatedEmployee.getEmail());

      Employee updatedEmployeeObj=  employRepository.save(employee);


        return EmployeMapper.mapToEmployeeDto(updatedEmployeeObj);
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        Employee employee=  employRepository.findById(employeeId).orElseThrow(()->new ResourceNotFoundException("Employee not exists with given id"+employeeId));

        employRepository.deleteById(employeeId);

    }
}
