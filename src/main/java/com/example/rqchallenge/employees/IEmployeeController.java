package com.example.rqchallenge.employees;

import com.example.rqchallenge.exception.EmployeeException;
import com.example.rqchallenge.models.CreateEmployee;
import com.example.rqchallenge.models.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
public interface IEmployeeController {

    @GetMapping()
    ResponseEntity<List<Employee>> getAllEmployees() throws EmployeeException;

    @GetMapping("/search/{searchString}")
    ResponseEntity<List<Employee>> getEmployeesByNameSearch(@PathVariable String searchString) throws EmployeeException;

    @GetMapping("/{id}")
    ResponseEntity<Employee> getEmployeeById(@PathVariable String id) throws EmployeeException;

    @GetMapping("/highestSalary")
    ResponseEntity<Integer> getHighestSalaryOfEmployees() throws EmployeeException;

    @GetMapping("/topTenHighestEarningEmployeeNames")
    ResponseEntity<List<String>> getTopTenHighestEarningEmployeeNames() throws EmployeeException;

    @PostMapping("/create")
    ResponseEntity<CreateEmployee> createEmployee(@RequestBody Map<String, Object> employeeInput) throws EmployeeException;

    @DeleteMapping("/{id}")
    ResponseEntity<String> deleteEmployeeById(@PathVariable String id) throws EmployeeException;

}
