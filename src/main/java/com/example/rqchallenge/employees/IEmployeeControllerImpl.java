package com.example.rqchallenge.employees;

import com.example.rqchallenge.api.EmployeeService;
import com.example.rqchallenge.exception.EmployeeException;
import com.example.rqchallenge.models.CreateEmployee;
import com.example.rqchallenge.models.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
public class IEmployeeControllerImpl implements IEmployeeController {
    @Autowired
    private EmployeeService employeeService;

    private static final Logger logger = LoggerFactory.getLogger(IEmployeeControllerImpl.class);

    @Override
    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getAllEmployees() throws EmployeeException {
        logger.info("Get list of all Employees");

        List<Employee> employeesList = employeeService.getAllEmployees();
        return ResponseEntity.ok(employeesList);
    }

    @Override
    @GetMapping("/search/{searchString}")
    public ResponseEntity<List<Employee>> getEmployeesByNameSearch(@PathVariable String searchString) throws EmployeeException {
        logger.info("Get employees by search key");

        List<Employee> employeeList = employeeService.getEmployeesByNameSearch(searchString);

        return ResponseEntity.ok(employeeList);
    }

    @Override
    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable String id) throws EmployeeException {

        logger.info("IEmployeeControllerImplementation : Get employee by id");

        Employee employee = employeeService.getEmployeeById(id);

        return ResponseEntity.ok((Employee)employee);

    }

    @Override
    @GetMapping("/highestSalary")
    public ResponseEntity<Integer> getHighestSalaryOfEmployees() throws EmployeeException {

        logger.info("Get highest salary");

        Integer highestSalary = employeeService.getHighestSalaryOfEmployees();

        return new ResponseEntity<>(highestSalary, HttpStatus.OK);

    }

    @Override
    @GetMapping("/topTenHighestEarningEmployeeNames")
    public ResponseEntity<List<String>> getTopTenHighestEarningEmployeeNames() throws EmployeeException {

        logger.info("Get top 10 highest earning employee names");

        List<String> topEarningEmployeeNames = employeeService.getTopTenHighestEarningEmployeeNames();

        return new ResponseEntity<>(topEarningEmployeeNames, HttpStatus.OK);

    }

    @Override
    @PostMapping("/create")
    public ResponseEntity<CreateEmployee> createEmployee(@RequestBody Map<String, Object> employeeInput) throws EmployeeException{
        logger.info("create employee");

        CreateEmployee employee = employeeService.createEmployee(employeeInput);

        return new ResponseEntity<>(employee, HttpStatus.CREATED);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable String id) throws EmployeeException{
        logger.info("delete employee");


        String status = employeeService.deleteEmployeeById(id);

        return ResponseEntity.ok(status);


    }
}
