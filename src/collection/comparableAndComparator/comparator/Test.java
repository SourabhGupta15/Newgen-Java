package collection.comparableAndComparator.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        Set<Employee> employeeSet = new HashSet<>();
        employeeSet.add(new Employee("John", 2, 50000));
        employeeSet.add(new Employee("Rohan", 1, 10000));
        employeeSet.add(new Employee("Alice", 3, 30000));
        employeeSet.add(new Employee("Bob", 4, 20000));
        employeeSet.add(new Employee("Eve", 5, 40000));

        // Convert HashSet to List for sorting
        List<Employee> employeeList = new ArrayList<>(employeeSet);

        printList(employeeList);


        
        // 1. Normal Method
        Collections.sort(employeeList, new NameComparator());
        System.out.println("\nAfter Sorting by name");
        printList(employeeList);
        
        Collections.sort(employeeList, new IdComparator());     // Pass an object of comparator class created for different attribute
        System.out.println("\nAfter Sorting by ID");
        printList(employeeList);


        
        // 2. Using Anonymous Method
        Collections.sort(employeeList, new Comparator<Employee>() {     // In this technique you don't need to write extra class for comparator as you are defining the class here itself.
            // Descending sort by Salary
            @Override
            public int compare(Employee o1, Employee o2) {
                return Double.compare(o2.getSalary(), o1.getSalary());
            }
        });
        System.out.println("\nAfter Sorting by Salary Descending Anonymous Method");
        printList(employeeList);

        employeeList.add(new Employee("Bob", 6, 40000));

        Collections.sort(employeeList, new Comparator<Employee>() {
            // Ascending Name and Descending Salary if same Name.
            @Override
            public int compare(Employee e1, Employee e2) {
                // Ascending sort by Name
                int nameCompare = e1.getName().compareTo(e2.getName());
                
                // Descending sort by Salary
                if (nameCompare == 0) {
                    return Double.compare(e2.getSalary(), e1.getSalary());
                }

                return nameCompare;
            }
        });
        System.out.println("\nAfter Sorting by Name Ascending and Salary Descending for same Name Anonymous Method");
        printList(employeeList);



        // 3. Using Lambda Expression
        // Descending sort by Name
        employeeList.sort((e1, e2) -> e2.getName().compareTo(e1.getName()));    // No need to write Class of objects and also return.
        System.out.println("\nAfter Sorting by Name Descending Lambda Expression");
        printList(employeeList);

        // Ascending Name and Descending Salary if same Name.
        employeeList.sort((e1, e2) -> {
            int nameCompare = e1.getName().compareTo(e2.getName());
                
                // Descending sort by Salary
                if (nameCompare == 0) {
                    return Double.compare(e2.getSalary(), e1.getSalary());
                }

                return nameCompare;
        });
        System.out.println("\nAfter Sorting by Name Ascending and Salary Descending for same Name using Lambda Expression");
        printList(employeeList);


        
        // 4. Using Comparator.comparing
        // Ascending sort by Id
        // employeeList.sort(Comparator.comparingInt(Employee::getId));       // This is by method reference.   //comparingInt() for int and likewise.
        employeeList.sort(Comparator.comparingInt(emp -> emp.getId()));     // Use any of the two. Both are same. This is by lambda expression.
        System.out.println("\nAfter Sorting by ID Comparator.comparing");
        printList(employeeList);

        // Descending sort by Name
        employeeList.sort(Comparator.comparing(Employee::getName).reversed());  // Just add .reversed() method
        System.out.println("\nAfter Sorting by Name Descending Comparator.comparing");
        printList(employeeList);



        // 5. Using Stream API for Sorted Output (Not Modifying Original List)
        // Descending sort by Id
        List<Employee> sortedList = employeeList.stream().sorted(Comparator.comparingInt(Employee::getId).reversed()).toList();     // In sorted method, pass the Comparator.comparing method. Pass .toList() method to convert it to list. Stream API returns stream of elements from the list.
        System.out.println("\nAfter Sorting by Id Descending using Stream API");
        printList(sortedList);



        // 6. Chained comparisons (e.g., by name and then id, if names are equal)
        // Descending Name and then Ascending Id
        employeeList.sort(Comparator.comparing(Employee::getName).reversed().thenComparingInt(Employee::getId));   //You can add multiple thenComparing()
        System.out.println("\nChained Comparison -> Descending Name and Ascending Id");     //Adding .reversed() at the end reverses the whole list not just that attribute
        printList(employeeList);

        // Ascending Name and then Descending Id
        employeeList.sort(Comparator.comparing(Employee::getName).reversed().thenComparingInt(Employee::getId).reversed());     // for int use thenComparingINt() and likewise for different datatype except string.
        System.out.println("\nChained Comparison -> Ascending Name and Descending Id");
        printList(employeeList);
    }

    public static void printList(List<Employee> empList) {
        for (Employee emp : empList) {
            System.out.println(emp.toString());
        }
    }
}
