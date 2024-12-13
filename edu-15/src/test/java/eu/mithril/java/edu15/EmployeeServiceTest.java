package eu.mithril.java.edu15;


import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import eu.mithril.java.edu15.model.Employee;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

// Service tests focusing on business logic and validation
public class EmployeeServiceTest {

    private EmployeeRepository repository = Mockito.mock(EmployeeRepository.class);

    private EmployeeService employeeService = new EmployeeServiceImpl(repository);

    private Employee testEmployee;

    @BeforeEach
    void setUp() {
        testEmployee = new Employee(1, "Radnik", "Udarnik", "radnik.udarnik@acme.com",
                LocalDate.now(), Department.IT, 50000.0);
    }

    @Test
    void addEmployeeShouldSaveValidEmployee() {
        when(repository.save(any(Employee.class))).thenReturn(testEmployee);

        Employee saved = employeeService.addEmployee(testEmployee);

        assertNotNull(saved);
        verify(repository).save(testEmployee);
    }

    @Test
    void addEmployeeShouldRejectInvalidName() {
        testEmployee = new Employee(1, "", "Doe",
                "john@company.com", LocalDate.now(),
                Department.IT, 50000.0);

        assertThrows(IllegalArgumentException.class, () ->
                employeeService.addEmployee(testEmployee));

        verify(repository, never()).save(any());
    }

    @Test
    void findByIdShouldReturnExistingEmployee() {
        when(repository.findById(1)).thenReturn(testEmployee);

        Employee found = employeeService.findById(1);
        assertEquals(testEmployee, found);
    }

    @Test
    void findByIdShouldThrowExceptionForNonExistentEmployee() {
        when(repository.findById(anyInt())).thenReturn(null);

        assertThrows(IllegalArgumentException.class, () ->
                employeeService.findById(1));
    }

    @Test
    void findByDepartmentShouldReturnDepartmentEmployees() {
        List<Employee> employees = Arrays.asList(
                testEmployee,
                new Employee(2, "Jane", "Smith", "jane@company.com",
                        LocalDate.now(), Department.IT, 45000.0)
        );

        when(repository.findAll()).thenReturn(employees);

        List<Employee> found = employeeService.findByDepartment(Department.IT);
        assertEquals(2, found.size());
    }

    @Test
    void updateShouldModifyExistingEmployee() {
        when(repository.findById(1)).thenReturn(testEmployee);
        when(repository.save(any(Employee.class))).thenReturn(testEmployee);

        testEmployee.setSalary(55000.0);
        Employee updated = employeeService.update(testEmployee);

        assertNotNull(updated);
        verify(repository).save(testEmployee);
    }

    @Test
    void deleteShouldRemoveExistingEmployee() {
        when(repository.findById(1)).thenReturn(testEmployee);

        assertTrue(employeeService.delete(1));
        verify(repository).delete(1);
    }
}