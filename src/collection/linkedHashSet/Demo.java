package collection.linkedHashSet;

import java.util.LinkedHashSet;

public class Demo {
    public static void main(String[] args) {
        LinkedHashSet<Integer> lhs = new LinkedHashSet<>();
        lhs.add(20);
        lhs.add(50);
        lhs.add(10);
        lhs.add(30);
        lhs.add(40);
        lhs.add(null);
        lhs.add(null);

        System.out.println("lhs : " + lhs);
    }
}
