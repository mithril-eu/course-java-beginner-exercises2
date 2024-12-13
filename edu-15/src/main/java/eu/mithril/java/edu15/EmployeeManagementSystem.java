package eu.mithril.java.edu15;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
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
//        EmployeeRepository repository = new InMemoryEmployeeRepository();
//        this.employeeService = new EmployeeServiceImpl(repository);

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
        // Implement adding new employee with validation
    }

    private void searchEmployee() {
        // Implement search functionality
    }

    private void updateEmployee() {
        // Implement update functionality
    }

    private void deleteEmployee() {
        // Implement delete functionality
    }

    private void generateReports() {
        // Implement reporting functionality
    }
}
