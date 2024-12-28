package collection.treeSet;

import java.util.TreeSet;

public class Demo {
    public static void main(String[] args) {
        TreeSet<Integer> ts = new TreeSet<>();
        ts.add(20);
        ts.add(50);
        ts.add(10);
        ts.add(30);
        ts.add(40);
        // ts.add(null); does not allow null values for sorting.
        // ts.add(null);

        System.out.println("ts : " + ts);

        TreeSet<Object> ts1 = new TreeSet<>();
        ts1.add("Rahul");
        ts1.add(10);
        System.out.println("ts1 : " + ts1); //throws exception because it cannot compare String to Integer for sorting.
    }
}
