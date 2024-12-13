package eu.mithril.java.edu15;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import eu.mithril.java.edu15.model.Employee;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EmployeeRepositoryTest {

    private EmployeeRepository repository;
    private Employee testEmployee;

    @BeforeEach
    void setUp() {
        // TODO
        // repository = new InMemoryEmployeeRepository();
        testEmployee = new Employee(0, "Radnik", "Udarnik", "radnik.udarnik@acme.com",
                LocalDate.now(), Department.IT, 50000.0);
    }

    @Test
    void saveNewEmployeeShouldAssignId() {
        Employee saved = repository.save(testEmployee);

        assertNotNull(saved);
        assertTrue(saved.getId() > 0);
    }

    @Test
    void findByIdShouldReturnSavedEmployee() {
        Employee saved = repository.save(testEmployee);
        Employee found = repository.findById(saved.getId());

        assertNotNull(found);
        assertEquals(saved.getId(), found.getId());
        assertEquals(saved.getEmail(), found.getEmail());
    }

    @Test
    void findByIdShouldReturnNullForNonExistentEmployee() {
        Employee found = repository.findById(999);
        assertNull(found);
    }

    @Test
    void findAllShouldReturnAllEmployees() {
        repository.save(testEmployee);
        repository.save(new Employee(0, "Jane", "Smith",
                "jane@company.com", LocalDate.now(),
                Department.HR, 45000.0));

        List<Employee> allEmployees = repository.findAll();
        assertEquals(2, allEmployees.size());
    }

    @Test
    void deleteShouldRemoveEmployee() {
        Employee saved = repository.save(testEmployee);
        repository.delete(saved.getId());
        assertNull(repository.findById(saved.getId()));
    }
}
