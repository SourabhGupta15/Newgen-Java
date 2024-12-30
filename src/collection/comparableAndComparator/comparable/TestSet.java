package collection.comparableAndComparator.comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TestSet {
    public static void main(String[] args) {
        Set<Employee> employeeSet = new HashSet<>();
        employeeSet.add(new Employee("John", 2, 50000));
        employeeSet.add(new Employee("Rohan", 1, 10000));
        employeeSet.add(new Employee("Alice", 3, 30000));
        employeeSet.add(new Employee("Bob", 4, 20000));
        employeeSet.add(new Employee("Eve", 5, 40000));

        // Convert HashSet to List for sorting
        List<Employee> employeeList = new ArrayList<>(employeeSet);
        
        // And then follow the procedure for sorting list using comparable
        Collections.sort(employeeList);
        System.out.println("\nAfter Sorting");
        printList(employeeList);
    }

    public static void printList(List<Employee> empList) {
        for (Employee emp : empList) {
            System.out.println(emp.toString());
        }
    }
}
