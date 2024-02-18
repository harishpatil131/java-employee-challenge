package com.example.rqchallenge.exception;

import com.example.rqchallenge.enums.ErrorCodes;

public class EmployeeException extends Exception {
    private ErrorCodes errorCodes;
    private String errorMessage;

    public EmployeeException(ErrorCodes errorCodes, String errorMessage) {
        this.errorCodes = errorCodes;
        this.errorMessage = errorMessage;
    }

    public void setErrorCode(ErrorCodes errorCodes) {
        this.errorCodes = errorCodes;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public ErrorCodes getErrorCode() {
        return errorCodes;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
