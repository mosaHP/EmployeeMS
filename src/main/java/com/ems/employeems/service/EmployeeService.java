package com.ems.employeems.service;

import com.ems.employeems.employee.Employee;
import com.ems.employeems.exception.EmployeeNotFoundException;
import com.ems.employeems.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee findEmployeeById(Long id) {
        return employeeRepository.findById(id).orElseThrow(()-> new EmployeeNotFoundException("Employee with id " + id + " not found!"));
    }

    public void delete(Long id) {
        employeeRepository.deleteById(id);
    }

}
