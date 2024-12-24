package collection.vector;

import java.util.Vector;

public class Demo {
    public static void main(String[] args) {
        Vector<String> v1 = new Vector<>();
        v1.add("Rahul");
        v1.add("Rohan");
        v1.add("Manoj");
        v1.add("Rushi");
        v1.add("Riyaz");

        System.out.println("v1 : " + v1);

        v1.set(2, "Ashutosh");
        System.out.println("v1 after v1.set(2, 'Ashutosh'): " + v1);

        //Same methods as ArrayList and LinkedList
    }
}
