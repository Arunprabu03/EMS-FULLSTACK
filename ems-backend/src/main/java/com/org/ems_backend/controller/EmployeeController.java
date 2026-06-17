package com.org.ems_backend.controller;


import com.org.ems_backend.dto.EmployeeDto;
import com.org.ems_backend.service.EmployeeService;
import lombok.AllArgsConstructor;
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


    //Add Employee
    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto savedEmployee=employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    //get single Employee
    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long employeeId){
        EmployeeDto employeeDto=employeeService.getEmployeeById((employeeId));
        return new ResponseEntity<>(employeeDto, HttpStatus.OK);
    }

    //get All Employee
    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployee(){
        List<EmployeeDto> employees=employeeService.getAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    //Update Employee
    @PutMapping("{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long employeeId, @RequestBody EmployeeDto updatedEmployee){
        EmployeeDto employeeDto=employeeService.updateEmployee(employeeId, updatedEmployee);
        return new ResponseEntity<>(employeeDto, HttpStatus.OK);
    }

    //Delete Employee
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId){
        employeeService.deleteEmployee(employeeId);
        return  ResponseEntity.ok("Employee deleted Successfully");
    }
}
