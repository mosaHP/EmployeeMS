package com.ems.employeems.controller;

import com.ems.employeems.employee.Employee;
import com.ems.employeems.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public Employee getEmployeeById(@PathVariable("id") Long id) {
        return employeeService.findEmployeeById(id);
    }
    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Employee> updateemployee(@PathVariable("id") Long id, @RequestBody Employee employee) {
        Employee updatedEmployee = employeeService.findEmployeeById(id);
        updatedEmployee.setName(employee.getName());
        updatedEmployee.setSurname(employee.getSurname());
        updatedEmployee.setId(employee.getId());
        employeeService.addEmployee(updatedEmployee);
        return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id)
    {
        employeeService.delete(id);

    }
}
