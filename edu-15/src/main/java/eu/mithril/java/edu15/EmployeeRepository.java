package eu.mithril.java.edu15;

import java.util.List;

import eu.mithril.java.edu15.model.Employee;

public interface EmployeeRepository {

    Employee save(Employee employee);

    Employee findById(int id);

    List<Employee> findAll();

    void delete(int id);

}