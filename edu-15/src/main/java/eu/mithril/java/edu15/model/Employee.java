package eu.mithril.java.edu15.model;

import java.time.LocalDate;

import eu.mithril.java.edu15.Department;

public class Employee {

    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private LocalDate dateHired;
    private Department department;
    private double salary;

    public Employee(int id, String firstName, String lastName, String email,
                    LocalDate dateHired, Department department, double salary) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dateHired = dateHired;
        this.department = department;
        this.salary = salary;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getDateHired() {
        return dateHired;
    }

    public Department getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return String.format("%s %s [ID: %d, Email: %s, Department: %s, Salary: %.2f]",
                firstName, lastName, id, email, department, salary);
    }
}