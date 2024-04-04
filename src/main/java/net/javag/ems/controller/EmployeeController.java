package net.javag.ems.controller;


import lombok.AllArgsConstructor;
import lombok.Getter;
import net.javag.ems.dto.EmployDto;
import net.javag.ems.service.EmployeeService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private EmployeeService employeeService;
    //Build Add EMployee REST API
@PostMapping
    public ResponseEntity<EmployDto> createEmployee(@RequestBody EmployDto employDto){
       EmployDto savedEmployee=employeeService.createEmployee(employDto);
       return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);

    }
    //get employee rest api
    @GetMapping("{id}")
    public ResponseEntity<EmployDto>getEmployeeById(@PathVariable("id") Long employeeId){
    EmployDto employDto=employeeService.getEmployeeById(employeeId);

    return ResponseEntity.ok(employDto);
    }

    //getall employee rest api

    @GetMapping
    public ResponseEntity<List<EmployDto>> getAllEmployees(){
   List<EmployDto>employees= employeeService.getAllEmployees();
   return ResponseEntity.ok(employees);
    }
    //Build update EMployee Rest api
    @PutMapping("{id}")
    public ResponseEntity<EmployDto> updateEmployee(@PathVariable("id")
                                                         Long  employId,@RequestBody EmployDto updatedEmploy){
    EmployDto employDto=employeeService.updateEmployee(employId,updatedEmploy);
    return ResponseEntity.ok(employDto);
    }
    //Build Delete Employee REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId){
    employeeService.deleteEmployee(employeeId);
    return ResponseEntity.ok("EMployee deleted succesfully");
    }



}
