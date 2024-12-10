package staticKeyword;

public class Student {
    int id;
    String name;
    static String college = "JSPM";

    public Student(){}

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static void main(String[] args) {
        Student s1 = new Student(11, "Rohit");
        System.out.println(s1.name + " " + s1.id + " " + s1.college);

        Student.college = "DY Patil";

        System.out.println(s1.name + " " + s1.id + " " + s1.college);
        
        Student s2 = new Student(12, "Vikas");
        System.out.println(s2.name + " " + s2.id + " " + Student.college); // Correct way to call the college

        Student.college = "Ferguson";
        System.out.println(s2.college);
    }
}
