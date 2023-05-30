package com.example.employee.service.impl;

import com.example.employee.domain.Employee;
import com.example.employee.service.DepartmentService;
import com.example.employee.exception.InvalidInputException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final EmployeeServiceImpl employeeServiceImpl;

    public DepartmentServiceImpl(EmployeeServiceImpl employeeServiceImpl) {
        this.employeeServiceImpl = employeeServiceImpl;
    }

    @Override
    public Employee findMaxSalaryFromDepartment(int department) {
        return employeeServiceImpl.getEmployees().stream()
                .filter(employee -> employee.getDepartment() == department)
                .max(Comparator.comparing(Employee::getSalary))
                .orElseThrow(InvalidInputException::new);
    }

    @Override
    public Employee findMinSalaryFromDepartment(int department) {
        return employeeServiceImpl.getEmployees().stream()
                .filter(employee -> employee.getDepartment() == department)
                .min(Comparator.comparing(Employee::getSalary))
                .orElseThrow(InvalidInputException::new);
    }

    @Override
    public Collection<Employee> printAllFromDepartment(int department) {
        return employeeServiceImpl.getEmployees().stream()
                .filter(employee -> employee.getDepartment() == department)
                .toList();
    }

    @Override
    public Map<Integer, List<Employee>> printAllSortedByDepartment() {
        return employeeServiceImpl.getEmployees().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }

    @Override
    public BigDecimal printSalaryPerDepartment(int department) {
        BigDecimal sum = employeeServiceImpl.getEmployees().stream()
                .filter(employee -> employee.getDepartment() == department)
                .map(Employee::getSalary)
                .reduce(BigDecimal::add)
                .orElseThrow(InvalidInputException::new);
        return sum.setScale(2, RoundingMode.HALF_UP);
    }
}
