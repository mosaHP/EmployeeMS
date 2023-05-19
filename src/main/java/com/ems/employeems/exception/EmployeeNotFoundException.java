package com.ems.employeems.exception;

public class EmployeeNotFoundException extends RuntimeException{
    public EmployeeNotFoundException(final String message) {
        super(message);
    }
}
