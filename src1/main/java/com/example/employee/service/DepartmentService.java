package com.example.employee.service;

import com.example.employee.domain.Employee;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface DepartmentService {
    Employee findMaxSalaryFromDepartment(int department);

    Employee findMinSalaryFromDepartment(int department);

    Collection<Employee> printAllFromDepartment(int department);

    Map<Integer, List<Employee>> printAllSortedByDepartment();

    BigDecimal printSalaryPerDepartment(int department);

}
