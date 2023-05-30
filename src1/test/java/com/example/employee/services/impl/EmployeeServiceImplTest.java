package com.example.employee.services.impl;

import com.example.employee.domain.Employee;
import com.example.employee.exception.EmployeeAlreadyAddedException;
import com.example.employee.exception.EmployeeNotFoundException;
import com.example.employee.service.impl.EmployeeServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;

import static com.example.employee.constants.EmployeeServiceConstants.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import com.example.employee.service.ValidatorService;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceImplTest {
    @Mock
    private ValidatorService validatorMock;

    @InjectMocks
    private EmployeeServiceImpl out;

    @BeforeEach
    void setUp() {
        out.add("Qqqq", "Qqqq", "10000", 1);
        out.add("Wwww", "Wwww", "11000", 1);
        out.add("Eeee", "Eeee", "12000", 2);
        out.add("Rrrr", "Rrrr", "13000", 3);
    }

    @Test
    void shouldReturnCorrectCollectionOfEmployeeWhenGetEmployeesCalled() {
        Collection<Employee> actual = out.getEmployees();
        assertThat(actual).containsExactlyInAnyOrderElementsOf(EMP_LIST_1);
    }

    @Test
    void shouldAddCorrectEmployeeWhenAddCalled() {
        boolean actual = out.getEmployees().contains(EMP_1);
        assertTrue(actual);
    }

    @Test
    void shouldReturnCorrectEmployeeWhenAddCalled() {
        Employee actual = out.add("Tttt", "Tttt", "14000", 3);
        assertThat(actual).isEqualTo(EMP_5);
    }

    @Test
    void shouldThrowEmployeeAlreadyAddedExceptionWhenAddCalled() {
        assertThrows(EmployeeAlreadyAddedException.class,
                () -> out.add("Qqqq", "Qqqq", "10000", 1));
    }

    @Test
    void shouldRemoveCorrectEmployeeWhenRemoveCalled() {
        out.remove("Qqqq", "Qqqq", "10000", 1);
        assertFalse(out.getEmployees().contains(EMP_1));
    }

    @Test
    void shouldReturnCorrectEmployeeWhenRemoveCalled() {
        Employee actual = out.remove("Qqqq", "Qqqq", "10000", 1);
        assertThat(actual).isEqualTo(EMP_1);
    }

    @Test
    void shouldThrowEmployeeAlreadyAddedExceptionWhenRemoveCalled() {
        assertThrows(EmployeeNotFoundException.class,
                () -> out.remove("Tttt", "Tttt", "14000", 3));
    }

    @Test
    void shouldFindCorrectEmployeeWhenFindCalled() {
        Employee actual = out.find("Qqqq", "Qqqq", "10000", 1);
        assertEquals(EMP_1, actual);
    }

    @Test
    void shouldThrowEmployeeAlreadyAddedExceptionWhenFindCalled() {
        assertThrows(EmployeeNotFoundException.class,
                () -> out.find("Tttt", "Tttt", "14000", 3));
    }
}
