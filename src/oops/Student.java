package oops;

public class Student {
    String name;
    float age;
    int id;

    void printObj() {
        System.out.println("Name : " + this.name + ", Age : " + this.age + ", Id : " + this.id);
    }

    void assignValues(String name, float a, int id) {
        this.name = name;
        this.age = a;
        this.id = id;
    }

    public static void main(String[] args) {
        Student sourabh = new Student();
        sourabh.name = "Sourabh";
        sourabh.age = 24.9f;
        sourabh.id = 9343;
        sourabh.printObj();

        Student shruti = new Student();
        shruti.assignValues("Shruti", 22.2f, 123);
        shruti.printObj();
    }
}
