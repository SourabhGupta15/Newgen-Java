package oops;

public class Teacher {
    String name;
    int salary;
    String education;
    float experience;

    void teaching() {
        System.out.println(this.name + " is a good teacher.");
    } 
    
    void reading() {
        System.out.println(this.name + " likes to read books.");
    }
    
    void traveling() {
        System.out.println(this.name + " travels to work.");
    }

    void print() {
        System.out.println("Name : " + this.name + ", Salary : " + this.salary + ", Education : " + this.education + ", Experience : " + this.experience + "years.");
    }

    public static void main(String[] args) {
        Teacher ram = new Teacher();
        ram.name = "Ram Gade";
        ram.salary = 150000;
        ram.education = "B.Tech";
        ram.experience = 15.6f;
        ram.print();
        ram.reading();
        ram.traveling();
        ram.teaching();
    }
}
