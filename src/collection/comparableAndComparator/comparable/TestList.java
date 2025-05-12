package collection.comparableAndComparator.comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestList {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("John", 2, 50000));
        employees.add(new Employee("John", 1, 10000));
        employees.add(new Employee("Alice", 3, 30000));
        employees.add(new Employee("Bob", 4, 20000));
        employees.add(new Employee("Eve", 5, 40000));
        
        printList(employees);

        // Collections.sort(employees);
        // System.out.println("\nAfter sorting");
        // printList(employees);

        Collections.sort(employees, Collections.reverseOrder());    //So you don't need to write different compareTo() methods for sorting in different orders
        System.out.println("\nReverse order");
        printList(employees);
    }

    public static void printList(List<Employee> empList) {
        for (Employee emp : empList) {
            System.out.println(emp.toString());
        }
    }
}
