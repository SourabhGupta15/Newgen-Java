package practice;

public class Example {

    static void fun1() {
        System.out.println("fun1");
        fun3();
    }

    static void fun2() {
        System.out.println("fun2");
    }

    static void fun3() {
        System.out.println("fun3");
    }

    public static void main(String[] arg) {
        System.out.println("Start");
        fun1(); //method calling
        Example.fun2(); // another way of method calling
        System.out.println("End");
        A.fun1();
        A.fun2();
        Home obj1 = new Home(); // object creation and stored in reference variable obj1
        obj1.room = 5;
        new Home(); // object creation without reference variable
        Home obj2 = new Home(); // object creation and stored in reference variable obj2
        obj2.room = 8;
        System.out.println(obj1.name);
        System.out.println(obj2.name);
        obj2.getWaterConnection(); // changes static variable for both object
        System.out.println(obj1.name);
        System.out.println(obj2.name);
    }
}

class A {
    static void fun1() {
        System.out.println("fun1 from A");
        fun3();
    }

    static void fun2() {
        System.out.println("fun2 from A");
    }

    static void fun3() {
        System.out.println("fun3 from A");
    }
}

class Home {
    static String name = "Sourabh";
    int room;
    void getWaterConnection() {
        name = "Geeta";
    }
}

class Book {
    
}

// In a single class we can create multiple functions/method
// Main method is the starting point of java class -> it follows control flow
// method can be static and non-static
// we can write multiple methods in a single class
// we can create multiple classes in a single file
// only one class can be public and that public class should be the name of file
// every class can be public or default
// access specifiers in java : public, private, protected or default
// multiple objects can be created of single class
// class is a blueprint for creating an object
// when new object is created with same reference variable old obect is destroyed due to java garbage collection and the reference variable points toward the new object