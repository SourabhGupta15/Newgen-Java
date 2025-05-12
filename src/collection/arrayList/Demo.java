package collection.arrayList;

import java.util.*;

public class Demo {
    public static void main(String[] args) {
        List<Object> a1 = new ArrayList<>();
        a1.add(1.3f);
        a1.add("Mahnaz");
        a1.add("Ayan");
        a1.add('C');
        a1.add(5);
        System.out.println("ArrayList Elements : " + a1);

        a1.remove(3);
        System.out.println("ArrayList Elements : " + a1);
        
        a1.add(2, 11111111111111111l);
        System.out.println("ArrayList Elements : " + a1);
        
        a1.set(3, "Welcome to Java");
        System.out.println("ArrayList Elements : " + a1);
        
        System.out.println("Element at index 3 : " + a1.get(3));
        
        System.out.println("Index of object 7 : " + a1.indexOf(7));
        
        System.out.println("ArrayList contains object 5 : " + a1.contains(5));
        
        ArrayList<String> a2 = new ArrayList<>();
        a2.add("Hello");
        a2.add("Cool");
        a2.add(0, "WOW");
        System.out.println("Second ArrayList Elements : " + a2);

        a1.addAll(a2);
        System.out.println("ArrayList Elements : " + a1);

        a1.addAll(2, a2);
        System.out.println("ArrayList Elements : " + a1);

        System.out.println("Size of a1 : " + a1.size());

        a1.clear();
        System.out.println("ArrayList Elements : " + a1);

        for (String val : a2) {
            if (val.contains("Hello")) {
                System.out.println("val : " + val);
            }
        }
    }
}
