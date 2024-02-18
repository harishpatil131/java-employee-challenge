package com.example.rqchallenge.impl;

import com.example.rqchallenge.api.EmployeeService;
import com.example.rqchallenge.constants.APIConstants;
import com.example.rqchallenge.enums.Status;
import com.example.rqchallenge.exception.EmployeeException;
import com.example.rqchallenge.exception.ExceptionUtil;
import com.example.rqchallenge.models.*;
import com.example.rqchallenge.enums.ErrorCodes;
import com.example.rqchallenge.utils.APIUtils;
import com.example.rqchallenge.utils.JsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private APIUtils apiUtils;

    @Autowired
    private JsonUtils jsonUtils;

    private static final Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    @Override
    public List<Employee> getAllEmployees() throws EmployeeException {

        String apiResponse = null;

        try{
            apiResponse = apiUtils.get(APIConstants.HOST_URL_PREFIX + "/employees");
        }
        catch(Exception exception)
        {
            logger.error("Exception occurred while getting employee data : {0}", exception);
            throw ExceptionUtil.getCustomException(ErrorCodes.EXCEPTION_IN_CALLING_EXTERNAL_API);
        }

        EmployeesResponse employeesResponse = jsonUtils.jsonToEmployeesResponse(apiResponse);

        if(employeesResponse == null)
        {
            logger.error("No record found while calling " + APIConstants.HOST_URL_PREFIX + "/employees");
            throw ExceptionUtil.getCustomException(ErrorCodes.NO_RECORDS_FOUND);
        }

        return employeesResponse.getData();
    }

    public Employee getEmployeeById(String id) throws EmployeeException {

        if(id == null)
            throw ExceptionUtil.getCustomException(ErrorCodes.EMPLOYEE_ID_NOT_PASSED);

        String apiResponse = null;

        try{
            apiResponse = apiUtils.get(APIConstants.HOST_URL_PREFIX + "/employee/" + id);
        }
        catch(Exception exception)
        {
            logger.error("Exception occurred while getting employee data : {0}", exception);
            throw ExceptionUtil.getCustomException(ErrorCodes.EXCEPTION_IN_CALLING_EXTERNAL_API);
        }

        EmployeeResponse employeeResponse = jsonUtils.jsonToEmployeeResponse(apiResponse);

        if(employeeResponse == null)
        {
            logger.error("No record found while calling " + APIConstants.HOST_URL_PREFIX + "/employee/" + id);
            throw ExceptionUtil.getCustomException(ErrorCodes.NO_RECORDS_FOUND);
        }

        return employeeResponse.getData();
    }

    public CreateEmployee createEmployee(Map<String, Object> employeeInput) throws EmployeeException {

        String payLoad = null;

        CreateEmployee employee = getEmployeeObject(employeeInput);

        validateEmployee(employee);

        payLoad = jsonUtils.convertToJson(employee);

        String apiResponse = null;

        try{
            apiResponse = apiUtils.post(APIConstants.HOST_URL_PREFIX + "/create", payLoad);
        }
        catch(Exception exception)
        {
            logger.error("Exception occurred while creating employee data : {0}", exception);
            throw ExceptionUtil.getCustomException(ErrorCodes.EXCEPTION_IN_CALLING_EXTERNAL_API);
        }

        CreateEmployeeResponse createEmployeeResponse = jsonUtils.jsonToCreateEmployeeResponse(apiResponse);
        return createEmployeeResponse.getData();
    }

    public String deleteEmployeeById(String id) throws EmployeeException {

        if(id == null)
            throw ExceptionUtil.getCustomException(ErrorCodes.EMPLOYEE_ID_NOT_PASSED);

        try{
            apiUtils.delete(APIConstants.HOST_URL_PREFIX + "/delete/" + id);
        }
        catch(Exception exception)
        {
            logger.error("Exception occurred while deleting employee data : {0}", exception);
            throw ExceptionUtil.getCustomException(ErrorCodes.EXCEPTION_IN_CALLING_EXTERNAL_API);
        }
        return Status.SUCCESS.getStatus();

    }
    public List<Employee> getEmployeesByNameSearch(String searchString) throws EmployeeException {

        return getAllEmployees().stream()
                .filter(employee -> employee.getName().toLowerCase().contains(searchString.toLowerCase()))
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

    }
    public Integer getHighestSalaryOfEmployees() throws EmployeeException {

        return getAllEmployees().stream()
                .mapToInt(Employee::getSalary)
                .max()
                .orElse(0);
    }
    public List<String> getTopTenHighestEarningEmployeeNames() throws EmployeeException {

        return getAllEmployees().stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .limit(10)
                .map(Employee::getName)
                .collect(Collectors.toList());

    }



    private CreateEmployee getEmployeeObject(Map<String, Object> employeeInput){
        CreateEmployee employee = new CreateEmployee();
        if(employeeInput.get("name") != null)
            employee.setName(employeeInput.get("name").toString());
        employee.setAge((Integer) employeeInput.get("age"));
        employee.setSalary((Integer) employeeInput.get("salary"));

        return employee;
    }

    private void validateEmployee(CreateEmployee employee) throws EmployeeException {
        if (employee == null)
            throw ExceptionUtil.getCustomException(ErrorCodes.INVALID_CREATE_EMPLOYEE_OBJECT);
        if (employee.getName() == null)
            throw ExceptionUtil.getCustomException(ErrorCodes.EMPLOYEE_NAME_NOT_PASSED);
        if (employee.getSalary() == null)
            throw ExceptionUtil.getCustomException(ErrorCodes.EMPLOYEE_SALARY_NOT_PASSED);
        if (employee.getSalary() < 0)
            throw ExceptionUtil.getCustomException(ErrorCodes.INVALID_EMPLOYEE_SALARY_PASSED);
        if (employee.getAge() == null)
            throw ExceptionUtil.getCustomException(ErrorCodes.EMPLOYEE_AGE_NOT_PASSED);
        if (employee.getAge() < 0 || employee.getAge() > 100)
            throw ExceptionUtil.getCustomException(ErrorCodes.INVALID_EMPLOYEE_AGE_PASSED);
    }

}
