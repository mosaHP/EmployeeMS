package com.ems.employeems.controller;

import com.ems.employeems.entity.Employee;
import com.ems.employeems.exception.EmployeeNotFoundException;
import com.ems.employeems.exception.InvalidRequestException;
import com.ems.employeems.exception.ResourceNotFoundException;
import com.ems.employeems.service.interfaces.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List <Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }
    @GetMapping("/find/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Employee getEmployeeById(@PathVariable("id") Long id) throws EmployeeNotFoundException, ResourceNotFoundException {
        return employeeService.getEmployee(id);
    }
    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Employee addEmployee(@RequestBody Employee employee) throws InvalidRequestException, ResourceNotFoundException {
        return employeeService.addEmployee(employee);
    }
    @PutMapping("/update/{id}")
    public Employee updateemployee(@PathVariable("id") Long id, @RequestBody Employee employee) throws ResourceNotFoundException, InvalidRequestException {
        return employeeService.updateEmployee(id, employee);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id) throws ResourceNotFoundException {
        employeeService.deleteEmployee(id);

    }
}
