package com.example.employee.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

import static org.springframework.util.StringUtils.capitalize;

public class Employee {
    private final String firstName;
    private final String lastName;
    private BigDecimal salary;
    private int department;

    public Employee(String firstName, String lastName, String salary, int department) {
        this.firstName = capitalize(firstName.toLowerCase());
        this.lastName = capitalize(lastName.toLowerCase());
        this.salary = new BigDecimal(String.valueOf(salary));
        this.department = department;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public BigDecimal getSalary() {
        return salary.setScale(2, RoundingMode.HALF_UP);
    }

    public int getDepartment() {return department;}

    @Override
    public String toString() {
        return String.format(
                "ФИО - %s; Оклад - %.2f; Отдел - %d",
                firstName + " " + lastName,
                salary,
                department
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return department == employee.department &&
                Objects.equals(firstName, employee.firstName) &&
                Objects.equals(lastName, employee.lastName) &&
                Objects.equals(salary, employee.salary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, salary, department);
    }
}
