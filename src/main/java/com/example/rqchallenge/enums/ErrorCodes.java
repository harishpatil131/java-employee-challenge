package com.example.rqchallenge.enums;

public enum ErrorCodes {
    NO_RECORDS_FOUND("EMP_OO1"),
    EXCEPTION_IN_CALLING_EXTERNAL_API("EMP_002"),
    EXCEPTION_IN_JSON_TO_OBJECT_CONVERSION("EMP_003"),
    EXCEPTION_IN_OBJECT_TO_JSON_CONVERSION("EMP_004"),
    INTERNAL_SERVER_EXCEPTION("EMP_005"),
    INVALID_CREATE_EMPLOYEE_OBJECT("EMP_006"),
    EMPLOYEE_NAME_NOT_PASSED("EMP_007"),
    EMPLOYEE_SALARY_NOT_PASSED("EMP_008"),
    INVALID_EMPLOYEE_SALARY_PASSED("EMP_009"),
    EMPLOYEE_AGE_NOT_PASSED("EMP_010"),
    INVALID_EMPLOYEE_AGE_PASSED("EMP_011"),
    EMPLOYEE_ID_NOT_PASSED("EMP_012");

    private String code;

    ErrorCodes(String code){
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
