package eu.mithril.java.edu15;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import eu.mithril.java.edu15.model.Employee;

public interface EmployeeService {

    Employee addEmployee(Employee employee);

    Employee findById(int id);

    List<Employee> findAll();

    List<Employee> findByDepartment(Department dept);

    Employee update(Employee employee);

    boolean delete(int id);

    Map<Department, Long> getEmployeeCountByDepartment();

    Map<Department, Double> getAverageSalaryByDepartment();

    List<Employee> findEmployeesHiredAfter(LocalDate date);

}