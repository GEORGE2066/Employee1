package com.example.employee.constants;

import com.example.employee.domain.Employee;

import java.util.List;

public class EmployeeServiceConstants {
    public static final Employee EMP_1 = new Employee("Qqqq", "Qqqq", "10000", 1);
    public static final Employee EMP_2 = new Employee("Wwww", "Wwww", "11000", 1);
    public static final Employee EMP_3 = new Employee("Eeee", "Eeee", "12000", 2);
    public static final Employee EMP_4 = new Employee("Rrrr", "Rrrr", "13000", 3);
    public static final Employee EMP_5 = new Employee("Tttt", "Tttt", "14000", 3);

    public static final List<Employee> EMP_LIST_1 = List.of(EMP_1, EMP_2, EMP_3, EMP_4);
    public static final List<Employee> EMP_LIST_2 = List.of(EMP_1, EMP_2);
}
