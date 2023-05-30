package com.example.employee.service.impl;


import com.example.employee.domain.Employee;

import java.util.Collection;

public interface EmployeeService {
    Employee add(String firstName, String lastName, String salary, int department);

    Employee remove(String firstName, String lastName, String salary, int department);

    Employee find(String firstName, String lastName, String salary, int department);

    Collection<Employee> getEmployees();
}
