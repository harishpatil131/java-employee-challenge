package com.example.rqchallenge.api;

import com.example.rqchallenge.exception.EmployeeException;
import com.example.rqchallenge.models.CreateEmployee;
import com.example.rqchallenge.models.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeService {
    public List<Employee> getAllEmployees() throws EmployeeException;
    public List<Employee> getEmployeesByNameSearch(String searchString) throws EmployeeException;
    public Employee getEmployeeById(String id) throws EmployeeException;
    public Integer getHighestSalaryOfEmployees() throws EmployeeException;
    public List<String> getTopTenHighestEarningEmployeeNames() throws EmployeeException;
    public CreateEmployee createEmployee(Map<String, Object> employeeInput) throws EmployeeException;   //Success
    public String deleteEmployeeById(String id) throws EmployeeException;




}
