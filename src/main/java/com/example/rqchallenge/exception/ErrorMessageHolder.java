package com.example.rqchallenge.exception;

import com.example.rqchallenge.enums.ErrorCodes;

import java.util.HashMap;
import java.util.Map;

public class ErrorMessageHolder {
    private static Map<ErrorCodes,String> errorCodeMessageMap = new HashMap<ErrorCodes, String>();

    static {
        errorCodeMessageMap.put(ErrorCodes.NO_RECORDS_FOUND, "No Records Found");
        errorCodeMessageMap.put(ErrorCodes.EXCEPTION_IN_CALLING_EXTERNAL_API, "Exception occurred while calling https://dummy.restapiexample.com/api/v1");
        errorCodeMessageMap.put(ErrorCodes.EXCEPTION_IN_JSON_TO_OBJECT_CONVERSION, "Exception occurred while converting JSON to Object");
        errorCodeMessageMap.put(ErrorCodes.EXCEPTION_IN_OBJECT_TO_JSON_CONVERSION, "Exception occurred while converting object to JSON");
        errorCodeMessageMap.put(ErrorCodes.INVALID_CREATE_EMPLOYEE_OBJECT, "Please pass employee object");
        errorCodeMessageMap.put(ErrorCodes.EMPLOYEE_NAME_NOT_PASSED, "Employee name not passed");
        errorCodeMessageMap.put(ErrorCodes.EMPLOYEE_SALARY_NOT_PASSED, "Employee salary not passed");
        errorCodeMessageMap.put(ErrorCodes.INVALID_EMPLOYEE_SALARY_PASSED, "Invalid Employee salary passed");
        errorCodeMessageMap.put(ErrorCodes.EMPLOYEE_AGE_NOT_PASSED, "Employee age not passed");
        errorCodeMessageMap.put(ErrorCodes.INVALID_EMPLOYEE_AGE_PASSED, "Invalid Employee age passed");
        errorCodeMessageMap.put(ErrorCodes.EMPLOYEE_ID_NOT_PASSED, "Employee Id not passed");
        errorCodeMessageMap.put(ErrorCodes.INTERNAL_SERVER_EXCEPTION, "Internal Server Exception");


    }

    public static Map<ErrorCodes, String> getErrorCodeMessageMap() {
        return errorCodeMessageMap;
    }

    public static void setErrorCodeMessageMap(Map<ErrorCodes, String> errorCodeMessageMap) {
        ErrorMessageHolder.errorCodeMessageMap = errorCodeMessageMap;
    }

    public static String getErrorMessage(ErrorCodes errorCode)
    {
        return errorCodeMessageMap.get(errorCode);
    }
}
