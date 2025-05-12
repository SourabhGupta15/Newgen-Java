package collection.comparableAndComparator.comparator;

import java.util.Comparator;

public class IdComparator implements Comparator<Employee> {
    // Ascending sort by Id
    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getId() - o2.getId();
        // return Integer.compare(o1.getId(), o2.getId());
    }

    // For descending change above logic by swapping
}
