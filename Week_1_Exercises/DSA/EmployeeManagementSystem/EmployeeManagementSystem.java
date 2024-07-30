package EmployeeManagementSystem;

public class EmployeeManagementSystem {
    public static void main(String[] args) {
        EmployeeManagement management = new EmployeeManagement(10);

        management.addEmployee(new Employee(101, "Employee1", "Developer", 50000));
        management.addEmployee(new Employee(102, "Employee2", "Senior Developer", 60000));
        management.addEmployee(new Employee(103, "Employee3", "HR", 70000));

        System.out.println("All Employees:");
        management.traverseEmployees();

        System.out.println("\nSearching for employee with ID 2:");
        Employee emp = management.searchEmployee(2);
        System.out.println(emp != null ? emp : "Employee not found");

        System.out.println("\nDeleting employee with ID 2:");
        boolean isDeleted = management.deleteEmployee(2);
        System.out.println(isDeleted ? "Employee deleted successfully" : "Employee not found");

        System.out.println("\nAll Employees after deletion:");
        management.traverseEmployees();
    }
}

