package collection.comparableAndComparator.comparable;

public class Employee implements Comparable<Employee> {
    private String name;
    private int id;
    private double salary;

    // Ascending order by name first and then ascending order by salary
    @Override
    public int compareTo(Employee o) {
        // Sorting basis on name ascending order
        int nameCompare = this.getName().compareTo(o.getName());

        // Sorting basis on salary ascending order
        if (nameCompare == 0) {
            return (int) (this.getSalary() - o.getSalary());
        }       // You can keep nesting nested-ifs for multiple attributes scenarios
        
        return nameCompare;     // Follow similar method for different attributes and swapping for different orders.
    }
    
    // Ascending order by name
    // @Override
    // public int compareTo(Employee o) {
            // return this.getName().compareTo(o.getName());
    // }

    // Descending order by name
    // @Override
    // public int compareTo(Employee o) {
            // return o.getName().compareTo(this.getName());
    // }

    // Ascending order by id
    // @Override
    // public int compareTo(Employee o) {
    //     return Integer.compare(this.getId(), o.getId());
    //     // return this.getId() - o.getId();
    // }

    // Descending order by id
    // @Override
    // public int compareTo(Employee o) {
    //     // return Integer.compare(o.getId(), this.getId());
    //     return o.getId() - this.getId();
    // }

    // Ascending order by salary
    // @Override
    // public int compareTo(Employee o) {
    //     return Double.compare(this.getSalary(), o.getSalary()); //Use wrapper classes for different data types
    //     // return (int) (this.getSalary() - o.getSalary());     //typecast it into int as it returns double and we have to return int value to sort method
    // }

    // Descending order by salary
    // @Override
    // public int compareTo(Employee o) {
    //     // return Double.compare(o.getSalary(), this.getSalary());
    //     return (int) (o.getSalary() - this.getSalary());
    // }

    public Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name = '" + name +
                "', id = " + id +
                ", salary = " + salary +
                "}";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
