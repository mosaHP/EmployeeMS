package com.ems.employeems.exception;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@Log4j2
@RestControllerAdvice("com.ems.employeems")
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ErrorDetails globalExceptionHandler(final Exception ex, final WebRequest request) {
        log.error("Internal Server Error! " + ex.getMessage());

        return new ErrorDetails(
                ex.getMessage(),
                LocalDateTime.now()
        );
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidRequestException.class)
    public ErrorDetails invalidRequestException(final InvalidRequestException ex, final WebRequest request) {

        return new ErrorDetails(
                ex.getMessage(),
                LocalDateTime.now()
        );
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(EmployeeNotFoundException.class)
    public ErrorDetails employeeNotFoundException(final EmployeeNotFoundException ex, final WebRequest request) {

        return new ErrorDetails(
                ex.getMessage(),
                LocalDateTime.now()
        );
    }

}
