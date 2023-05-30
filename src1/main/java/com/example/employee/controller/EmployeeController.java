package com.example.employee.controller;

import com.example.employee.domain.Employee;
import com.example.employee.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {
    private final EmployeeService emplService;

    public EmployeeController(EmployeeService emplService) {
        this.emplService = emplService;
    }

    @GetMapping(path = "/add")
    public Employee add(@RequestParam String firstName,
                        @RequestParam String lastName,
                        @RequestParam String salary,
                        @RequestParam int department) {
        return emplService.add(firstName, lastName, salary, department);
    }

    @GetMapping(path = "/remove")
    public Employee remove(@RequestParam String firstName,
                           @RequestParam String lastName,
                           @RequestParam String salary,
                           @RequestParam int department) {
        return emplService.remove(firstName, lastName, salary, department);
    }

    @GetMapping(path = "/find")
    public Employee find(@RequestParam String firstName,
                         @RequestParam String lastName,
                         @RequestParam String salary,
                         @RequestParam int department) {
        return emplService.find(firstName, lastName, salary, department);
    }

    @GetMapping
    public Collection<Employee> printAll() {
        return emplService.getEmployees();
    }
}
