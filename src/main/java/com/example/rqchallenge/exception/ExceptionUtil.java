package com.example.rqchallenge.exception;

import com.example.rqchallenge.enums.ErrorCodes;

public class ExceptionUtil {
    public static EmployeeException getCustomException(ErrorCodes errorCode){
        String errorMessage  = ErrorMessageHolder.getErrorMessage(errorCode);
        return new EmployeeException(errorCode, errorMessage);  
    }
}
