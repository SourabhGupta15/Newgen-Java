package practice;

class Employee {
    private int baseSalary;
    private int hourlyRate;

    private static int numberOfEmployees;

    public Employee(int baseSalary) {
        this(baseSalary, 0);
    }

    public Employee(int baseSalary, int hourlyRate) {
        setBaseSalary(baseSalary);
        setHourlyRate(hourlyRate);
        numberOfEmployees++;
    }

    public static void printNumberOfEmployees() {
        System.out.println(numberOfEmployees);
    }

    public int calculateWage(int extraHours) {
        return baseSalary + (hourlyRate * extraHours);
    }

    public int calculateWage() {
        return calculateWage(0);
    }

    private void setBaseSalary(int baseSalary) {
        if (baseSalary <= 0)
            throw new IllegalArgumentException("Salary cannot be 0 or less.");
        this.baseSalary = baseSalary;
    }

    private int getBaseSalary() {
        return baseSalary;
    }

    private void setHourlyRate(int hourlyRate) {
        if (hourlyRate < 0)
            throw new IllegalArgumentException("Hourly rate cannot be neagtive.");
        this.hourlyRate = hourlyRate;
    }

    private int getHourlyRate() {
        return hourlyRate;
    }

    public static void main (String[] args) {
        System.out.println("Hello World");
    }
}

// total 3 classes used in this code : Employee, String, System
// Class name in Upper Camel Case : NewgenEmployee{}
// Method name in Lower Camel Case : newgenEmployee(){}
// file name is always name of the class
/* in terminal run : 1) javac Employee.java    -> Creates .class file
                     2) java Employee          -> Runs .class file
*/
// .class file can be used in any operating system (create once use everywhere)