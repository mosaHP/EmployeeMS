package com.ems.employeems.service.impl;

import com.ems.employeems.entity.Employee;
import com.ems.employeems.exception.InvalidRequestException;
import com.ems.employeems.exception.ResourceNotFoundException;
import com.ems.employeems.repository.EmployeeRepository;
import com.ems.employeems.service.interfaces.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee getEmployee(Long id) throws ResourceNotFoundException {
        return employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee with id " + id + " not found!"));
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee addEmployee(Employee EmpPojo) throws InvalidRequestException, ResourceNotFoundException {
        return employeeRepository.save(EmpPojo);
    }

    @Override
    public Employee updateEmployee(long id, Employee EmpPojo) throws ResourceNotFoundException, InvalidRequestException {
        Employee updatedEmployee = getEmployee(id);
        updatedEmployee.setName(EmpPojo.getName());
        updatedEmployee.setSurname(EmpPojo.getSurname());
        updatedEmployee.setId(EmpPojo.getId());
        addEmployee(updatedEmployee);
        return updatedEmployee;
    }

    @Override
    public void deleteEmployee(long id) throws ResourceNotFoundException {
        employeeRepository.deleteById(id);
    }
}
