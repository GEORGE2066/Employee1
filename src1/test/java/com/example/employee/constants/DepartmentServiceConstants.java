package com.example.employee.constants;

import com.example.employee.domain.Employee;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;

import static com.example.employee.constants.EmployeeServiceConstants.*;

public class DepartmentServiceConstants {
    public static final int DEP_1 = 1;
    public static final int DEP_4 = 4;
    public static final BigDecimal SUM_SALARY_DEP_1 =
            BigDecimal.valueOf(21_000).setScale(2, RoundingMode.HALF_UP);

    public static final Map<Integer, List<Employee>> EMP_MAP = Map.of(
            1, List.of(EMP_1, EMP_2),
            2, List.of(EMP_3),
            3, List.of(EMP_4));
}
