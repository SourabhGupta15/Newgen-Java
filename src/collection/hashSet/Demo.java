package collection.hashSet;

import java.util.HashSet;

public class Demo {
    public static void main(String[] args) {
        HashSet<Integer> hs = new HashSet<>();
        hs.add(40);
        hs.add(20);
        hs.add(30);
        hs.add(50);
        hs.add(10);
        hs.add(10);
        hs.add(null);
        hs.add(null);

        System.out.println("hs : " + hs);

        HashSet<String> hs1 = new HashSet<>();
        hs1.add("Rohan");
        hs1.add("Salman");
        hs1.add("Aditya");
        hs1.add("Aditya");
        hs1.add("Akash");
        hs1.add(null);
        hs1.add(null);
        hs1.add("");
        hs1.add("");
        hs1.add("null");

        System.out.println("hs1 : " + hs1);

        HashSet hs2 = new HashSet<>();
        hs2.add("Rahul");
        hs2.add(10);
        System.out.println("hs2 : " + hs2);

        hs2.addAll(hs);
        System.out.println("hs2 : " + hs2);

        //hs.addAll(hs1); //String Set cannot be added to Integer Set

        hs.addAll(hs2); //The elements in hs2 is stored as type of 'Object' and every datatype Wrapper Class is a child of 'Object'. So it allows Integer/String/Double/etc Set to store Object Set elements.
        System.out.println("hs : " + hs);
    }
}
