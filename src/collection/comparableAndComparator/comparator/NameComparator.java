package collection.comparableAndComparator.comparator;

import java.util.Comparator;

public class NameComparator implements Comparator<Employee> {
    // Ascending sort by name
    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getName().compareTo(o2.getName());
    }

    // For Descending change above logic by swapping
}
