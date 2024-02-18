package com.example.rqchallenge.utils;
import com.example.rqchallenge.enums.ErrorCodes;
import com.example.rqchallenge.exception.EmployeeException;
import com.example.rqchallenge.exception.ExceptionUtil;
import com.example.rqchallenge.models.CreateEmployee;
import com.example.rqchallenge.models.CreateEmployeeResponse;
import com.example.rqchallenge.models.EmployeeResponse;
import com.example.rqchallenge.models.EmployeesResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class JsonUtils {

    @Autowired
    private ObjectMapper objectMapper;

    private static final Logger logger = LoggerFactory.getLogger(JsonUtils.class);


    public EmployeeResponse jsonToEmployeeResponse(String json) throws EmployeeException {
        try{
            return objectMapper.readValue(json, EmployeeResponse.class);
        } catch (Exception exception){
            logger.error("Exception occurred while converting json to object : " + exception);
            throw ExceptionUtil.getCustomException(ErrorCodes.EXCEPTION_IN_JSON_TO_OBJECT_CONVERSION);
        }
    }

    public EmployeesResponse jsonToEmployeesResponse(String json) throws EmployeeException {
        try{
            return objectMapper.readValue(json, EmployeesResponse.class);
        }catch (Exception exception){
            logger.error("Exception occurred while converting json to object : " + exception);
            throw ExceptionUtil.getCustomException(ErrorCodes.EXCEPTION_IN_JSON_TO_OBJECT_CONVERSION);
        }
    }

    public String convertToJson(CreateEmployee employee) throws EmployeeException{
        try{
            return objectMapper.writeValueAsString(employee);
        }catch (Exception exception){
            logger.error("Exception occurred while converting object to json : " + exception);
            throw ExceptionUtil.getCustomException(ErrorCodes.EXCEPTION_IN_OBJECT_TO_JSON_CONVERSION);
        }
    }

    public CreateEmployeeResponse jsonToCreateEmployeeResponse(String json) throws EmployeeException {
        try{
            return objectMapper.readValue(json, CreateEmployeeResponse.class);
        }catch (Exception exception){
            logger.error("Exception occurred while converting json to object : " + exception);
            throw ExceptionUtil.getCustomException(ErrorCodes.EXCEPTION_IN_JSON_TO_OBJECT_CONVERSION);
        }
    }
}
