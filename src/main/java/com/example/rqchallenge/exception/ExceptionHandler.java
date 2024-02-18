package com.example.rqchallenge.exception;

import com.example.rqchallenge.enums.ErrorCodes;
import com.example.rqchallenge.models.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(EmployeeException.class)
    public ResponseEntity<ErrorResponse> handleCustomException(EmployeeException employeeException)
    {
        return new ResponseEntity<>(new ErrorResponse(employeeException.getErrorCode().getCode(), employeeException.getErrorMessage()),
                HttpStatus.BAD_REQUEST);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleCustomException(Exception exception)
    {
        return new ResponseEntity<>(new ErrorResponse(ErrorCodes.INTERNAL_SERVER_EXCEPTION.getCode(), ErrorMessageHolder.getErrorMessage(ErrorCodes.INTERNAL_SERVER_EXCEPTION)),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
