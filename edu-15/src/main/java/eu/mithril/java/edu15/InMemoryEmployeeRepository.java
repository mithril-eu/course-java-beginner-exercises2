package eu.mithril.java.edu15;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import eu.mithril.java.edu15.model.Employee;

public class InMemoryEmployeeRepository implements EmployeeRepository {

    private Map<Integer, Employee> employeeDb = new HashMap<>();
    private int nextId = 1;

    @Override
    public Employee save(Employee employee) {
        if (employee.getId() == 0) {
            Employee newEmployee = new Employee(
                    nextId++,
                    employee.getFirstName(),
                    employee.getLastName(),
                    employee.getEmail(),
                    employee.getDateHired(),
                    employee.getDepartment(),
                    employee.getSalary()
            );
            employeeDb.put(newEmployee.getId(), newEmployee);
            return newEmployee;
        }
        employeeDb.put(employee.getId(), employee);
        return employee;
    }

    @Override
    public Employee findById(int id) {
        return employeeDb.get(id);
    }

    @Override
    public List<Employee> findAll() {
        return new ArrayList<>(employeeDb.values());
    }

    @Override
    public void delete(int id) {
        employeeDb.remove(id);
    }
}