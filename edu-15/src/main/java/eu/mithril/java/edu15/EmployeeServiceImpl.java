package eu.mithril.java.edu15;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import eu.mithril.java.edu15.model.Employee;

public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository repository;

    public EmployeeServiceImpl(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    public Employee addEmployee(Employee employee) {
        validateEmployee(employee);
        return repository.save(employee);
    }

    @Override
    public Employee findById(int id) {
        Employee employee = repository.findById(id);
        if (employee == null) {
            throw new IllegalArgumentException("Employee not found with ID: " + id);
        }
        return employee;
    }

    @Override
    public List<Employee> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Employee> findByDepartment(Department dept) {
        return repository.findAll().stream()
                .filter(emp -> emp.getDepartment() == dept)
                .collect(Collectors.toList());
    }

    @Override
    public Employee update(Employee employee) {
        findById(employee.getId()); // Verify exists
        validateEmployee(employee);
        return repository.save(employee);
    }

    @Override
    public boolean delete(int id) {
        findById(id); // Verify exists
        repository.delete(id);
        return true;
    }

    @Override
    public Map<Department, Long> getEmployeeCountByDepartment() {
        return repository.findAll().stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.counting()
                ));
    }

    @Override
    public Map<Department, Double> getAverageSalaryByDepartment() {
        return repository.findAll().stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)
                ));
    }

    @Override
    public List<Employee> findEmployeesHiredAfter(LocalDate date) {
        return repository.findAll().stream()
                .filter(emp -> emp.getDateHired().isAfter(date))
                .collect(Collectors.toList());
    }

    private void validateEmployee(Employee employee) {
        List<String> errors = new ArrayList<>();

        if (employee.getFirstName() == null || employee.getFirstName().trim().isEmpty()) {
            errors.add("First name is required");
        }
        if (employee.getLastName() == null || employee.getLastName().trim().isEmpty()) {
            errors.add("Last name is required");
        }
        if (employee.getEmail() == null || !employee.getEmail().matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            errors.add("Valid email is required");
        }
        if (employee.getDateHired() == null || employee.getDateHired().isAfter(LocalDate.now())) {
            errors.add("Valid hire date is required");
        }
        if (employee.getDepartment() == null) {
            errors.add("Department is required");
        }
        if (employee.getSalary() <= 0) {
            errors.add("Salary must be greater than 0");
        }

        if (!errors.isEmpty()) {
            throw new IllegalArgumentException("Validation failed: " + String.join(", ", errors));
        }
    }
}
