package eu.mithril.java.edu15;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import eu.mithril.java.edu15.model.Employee;

public class EmployeeManagementSystem {

    private final Scanner scanner;
    private EmployeeService employeeService;

    public EmployeeManagementSystem() {
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        // Initialize components
        EmployeeRepository repository = new InMemoryEmployeeRepository();
        this.employeeService = new EmployeeServiceImpl(repository);

        // Add some test data
        initializeTestData();

        boolean exit = false;
        while (!exit) {
            showMainMenu();
            int choice = readIntInput("Enter your choice: ");

            switch (choice) {
                case 1:
                    addNewEmployee();
                    break;
                case 2:
                    searchEmployee();
                    break;
                case 3:
                    updateEmployee();
                    break;
                case 4:
                    deleteEmployee();
                    break;
                case 5:
                    generateReports();
                    break;
                case 0:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        System.out.println("Thank you for using Employee Management System!");
        scanner.close();
    }

    private void initializeTestData() {
        try {
            employeeService.addEmployee(
                    new Employee(0, "Radnik", "Udarnik", "radnik.udarnik@acme.com", LocalDate.now(), Department.IT, 50000.0)
            );
        } catch (IllegalArgumentException e) {
            System.out.println("Error initializing test data: " + e.getMessage());
        }
    }

    private void showMainMenu() {
        System.out.println("\nEmployee Management System");
        System.out.println("1. Add new employee");
        System.out.println("2. Search employee");
        System.out.println("3. Update employee");
        System.out.println("4. Delete employee");
        System.out.println("5. Generate reports");
        System.out.println("0. Exit");
    }

    // Input validation methods
    private String readValidatedString(String prompt, String fieldName) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                System.out.println(fieldName + " cannot be empty. Please try again.");
                continue;
            }
            if (input.length() < 2) {
                System.out.println(fieldName + " must be at least 2 characters long.");
                continue;
            }
            return input;
        }
    }

    private String readValidatedEmail(String prompt) {
        while (true) {
            System.out.print(prompt);
            String email = scanner.nextLine().trim();

            String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
            if (email.matches(emailRegex)) {
                return email;
            }
            System.out.println("Invalid email format. Please try again.");
        }
    }

    private LocalDate readValidatedDate(String prompt) {
        while (true) {
            System.out.print(prompt);
            String dateStr = scanner.nextLine().trim();

            try {
                LocalDate date = LocalDate.parse(dateStr);
                if (date.isAfter(LocalDate.now())) {
                    System.out.println("Hire date cannot be in the future. Please try again.");
                    continue;
                }
                return date;
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Please use YYYY-MM-DD format.");
            }
        }
    }

    private Department readValidatedDepartment() {
        while (true) {
            System.out.println("Available departments:");
            for (Department dept : Department.values()) {
                System.out.println("- " + dept);
            }

            System.out.print("Enter department name: ");
            String input = scanner.nextLine().trim().toUpperCase();

            try {
                return Department.valueOf(input);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid department. Please try again.");
            }
        }
    }

    private double readValidatedSalary(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                double salary = Double.parseDouble(scanner.nextLine().trim());
                if (salary <= 0) {
                    System.out.println("Salary must be greater than 0. Please try again.");
                    continue;
                }
                return salary;
            } catch (NumberFormatException e) {
                System.out.println("Invalid number format. Please enter a valid amount.");
            }
        }
    }

    private int readIntInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    // TODO: Implement CRUD operations
    private void addNewEmployee() {
        System.out.println("\nAdd New Employee");
        System.out.println("----------------");

        String firstName = readValidatedString("Enter first name: ", "First name");
        String lastName = readValidatedString("Enter last name: ", "Last name");
        String email = readValidatedEmail("Enter email: ");
        LocalDate dateHired = readValidatedDate("Enter hire date (YYYY-MM-DD): ");
        Department department = readValidatedDepartment();
        double salary = readValidatedSalary("Enter salary: ");

        Employee employee = new Employee(0, firstName, lastName, email,
                dateHired, department, salary);

        Employee saved = employeeService.addEmployee(employee);
        System.out.println("Employee added successfully with ID: " + saved.getId());
    }

    private void searchEmployee() {
        System.out.println("\nSearch Employee");
        System.out.println("--------------");
        System.out.println("1. Search by ID");
        System.out.println("2. Search by Department");
        System.out.println("3. View all employees");

        int choice = readIntInput("Enter your choice: ");

        switch (choice) {
            case 1:
                int id = readIntInput("Enter employee ID: ");
                Employee employee = employeeService.findById(id);
                System.out.println(employee);
                break;

            case 2:
                Department dept = readValidatedDepartment();
                List<Employee> deptEmployees = employeeService.findByDepartment(dept);
                deptEmployees.forEach(System.out::println);
                break;

            case 3:
                List<Employee> allEmployees = employeeService.findAll();
                allEmployees.forEach(System.out::println);
                break;

            default:
                System.out.println("Invalid choice");
        }
    }

    private void updateEmployee() {
        System.out.println("\nUpdate Employee");
        System.out.println("---------------");

        int id = readIntInput("Enter employee ID: ");
        Employee existing = employeeService.findById(id);
        System.out.println("Current details: " + existing);

        String firstName = readValidatedString("Enter new first name: ", "First name");
        String lastName = readValidatedString("Enter new first name: ", "Last name");
        String email = readUpdatedString("Enter new email (Enter to keep current): ", existing.getEmail());
        Department department = readValidatedDepartment();
        double salary = readValidatedSalary("Enter salary: ");

        Employee updated = new Employee(id, firstName, lastName, email,
                existing.getDateHired(), department, salary);

        employeeService.update(updated);
        System.out.println("Employee updated successfully");
    }

    private String readUpdatedString(String prompt, String oldValue) {
        System.out.print(prompt);
        String input = scanner.nextLine().trim();
        if (input.isEmpty()) {
            return oldValue;
        }
        return input;
    }

    private void deleteEmployee() {
        System.out.println("\nDelete Employee");
        System.out.println("---------------");

        int id = readIntInput("Enter employee ID to delete: ");

        if (employeeService.delete(id)) {
            System.out.println("Employee deleted successfully");
        }
    }

    private void generateReports() {
        System.out.println("\nGenerate Reports");
        System.out.println("----------------");
        System.out.println("1. Employee count by department");
        System.out.println("2. Average salary by department");
        System.out.println("3. Recently hired employees");

        int choice = readIntInput("Enter your choice: ");

        switch (choice) {
            case 1:
                Map<Department, Long> countByDept = employeeService.getEmployeeCountByDepartment();
                countByDept.forEach((dept, count) ->
                        System.out.printf("%s: %d employees%n", dept, count));
                break;

            case 2:
                Map<Department, Double> avgSalaryByDept = employeeService.getAverageSalaryByDepartment();
                avgSalaryByDept.forEach((dept, avg) ->
                        System.out.printf("%s: $%.2f average salary%n", dept, avg));
                break;

            case 3:
                LocalDate threeMonthsAgo = LocalDate.now().minusMonths(3);
                List<Employee> recentHires = employeeService.findEmployeesHiredAfter(threeMonthsAgo);
                System.out.println("Employees hired in last 3 months:");
                recentHires.forEach(System.out::println);
                break;

            default:
                System.out.println("Invalid choice");
        }
    }
}
