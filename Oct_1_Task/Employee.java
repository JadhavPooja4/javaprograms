
//Task number 6.Collection Framework

package Oct_1_Task;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Employee {
    private ArrayList<String> employeeNames;

    public Employee() {
        employeeNames = new ArrayList<>();
    }

    public void addEmployee(String name) {
        employeeNames.add(name);
        System.out.println(name + " has been added....");
    }

    public void sortEmployees() {
        Collections.sort(employeeNames);
        System.out.println("Employee names sorted.");
    }

    public void displayEmployees() {
        System.out.println("Current employee names:");
        for (String name : employeeNames) {
            System.out.println(name);
        }
    }

    public boolean searchEmployee(String name) {
        return employeeNames.contains(name);
    }

    public void removeEmployee(String name) {
        if (employeeNames.remove(name)) {
            System.out.println(name + " Employee name has been removed.");
        } else {
            System.out.println(name + " Employee name is not found.");
        }
    }

    public static void main(String[] args) {
        Employee emp = new Employee();
        Scanner sc = new Scanner(System.in);
        String choice;

        while (true) {
            System.out.println("\nChoose an action: add, sort, display, search, remove, or exit:");
            choice = sc.nextLine().toLowerCase();

            switch (choice) {
                case "add":
                    System.out.print("Enter employee name: ");
                    String nameToAdd = sc.nextLine();
                    emp.addEmployee(nameToAdd);
                    break;

                case "sort":
                    emp.sortEmployees();
                    break;

                case "display":
                    emp.displayEmployees();
                    break;

                case "search":
                    System.out.print("Enter employee name to search: ");
                    String nameToSearch = sc.nextLine();
                    if (emp.searchEmployee(nameToSearch)) {
                        System.out.println(nameToSearch + " is found.");
                    } else {
                        System.out.println(nameToSearch + " is not found.");
                    }
                    break;

                case "remove":
                    System.out.print("Enter employee name to remove: ");
                    String nameToRemove = sc.nextLine();
                    emp.removeEmployee(nameToRemove);
                    break;

                case "exit":
                    System.out.println("Exiting the program.");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid command. Please try again.");
            }
        }
    }
}
