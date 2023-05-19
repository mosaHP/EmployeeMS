package com.ems.employeems.service.interfaces;

import com.ems.employeems.entity.Employee;
import com.ems.employeems.exception.InvalidRequestException;
import com.ems.employeems.exception.ResourceNotFoundException;

import java.util.List;

public interface EmployeeService {

    Employee getEmployee(Long id) throws ResourceNotFoundException;

    List<Employee> getAllEmployees();

    Employee addEmployee(Employee EmpPojo)
            throws InvalidRequestException, ResourceNotFoundException;
    Employee updateEmployee(long id, Employee EmpPojo) throws ResourceNotFoundException, InvalidRequestException;

    void deleteEmployee(long id) throws ResourceNotFoundException;
}
