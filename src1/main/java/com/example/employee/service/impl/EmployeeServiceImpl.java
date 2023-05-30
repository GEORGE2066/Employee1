package com.example.employee.service.impl;


import com.example.employee.domain.Employee;
import com.example.employee.exception.EmployeeAlreadyAddedException;
import com.example.employee.exception.EmployeeNotFoundException;
import com.example.employee.service.EmployeeService;
import com.example.employee.service.ValidatorService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final Map<String, Employee> employees = new HashMap<>();
    private final ValidatorService validatorService;

    public EmployeeServiceImpl(ValidatorService validatorService) {
        this.validatorService = validatorService;
    }

    private String getKey(Employee employee) {
        return employee.getFirstName() + " " + employee.getLastName();
    }

    @Override
    public Collection<Employee> getEmployees() {
        return Collections.unmodifiableCollection(employees.values());
    }

    @Override
    public Employee add(String firstName, String lastName, String salary, int department) {

        validatorService.checkInput(firstName, lastName);
        Employee employee = new Employee(firstName, lastName, salary, department);

        if (employees.containsKey(getKey(employee))) {
            throw new EmployeeAlreadyAddedException();
        }

        employees.put(getKey(employee), employee);
        return employee;
    }

    @Override
    public Employee remove(String firstName, String lastName, String salary, int department) {

        validatorService.checkInput(firstName, lastName);
        Employee employee = new Employee(firstName, lastName, salary, department);

        if (employees.containsKey(getKey(employee))) {
            return employees.remove(getKey(employee));
        }

        throw new EmployeeNotFoundException();
    }

    @Override
    public Employee find(String firstName, String lastName, String salary, int department) {

        validatorService.checkInput(firstName, lastName);
        Employee employee = new Employee(firstName, lastName, salary, department);

        if (employees.containsKey(getKey(employee))) {
            return employees.get(getKey(employee));
        }

        throw new EmployeeNotFoundException();
    }
}
