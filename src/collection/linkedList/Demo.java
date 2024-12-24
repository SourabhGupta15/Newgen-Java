package collection.linkedList;

import java.util.LinkedList;

public class Demo {
    public static void main(String[] args) {
        LinkedList<Integer> l1 = new LinkedList<>();

        l1.add(2);
        l1.add(5);
        l1.add(3);
        l1.add(1);
        l1.add(8);
        System.out.println("l1 : " + l1);

        l1.set(2, 10);
        System.out.println("l1 after l1.set(2, 10) : " + l1);

        LinkedList l2 = new LinkedList<>();
        l2.add(13);
        l2.add(14);
        l2.add(12);

        l2.addAll(l1);
        System.out.println("l2 after l2.addAll(l1) : " + l2);

        l1.addFirst(11);
        System.out.println("l1 after l1.addFirst(11) : " + l1);

        l1.addLast(20);
        System.out.println("l1 after l1.addLast(20) : " + l1);

        l2.clear();
        System.out.println("l2 after clear : " + l2);

        l1.remove(1);
        System.out.println("l1 after l1.remove(1) : " + l1);

        l1.remove(new Integer(11));
        System.out.println("l1 after l1.remove(new Integer(11)) : " + l1);

        //Print even numbers
        for (Integer num : l1) {
            if (num % 2 == 0) {
                System.out.print(num + " ");
            }
        }

        //Remove odd numbers
        /*for (int num : l1) {          //cannot perform two operations on a list simultaneously. First operation is iterating through it and second is performing remove operation.
            if (num % 2 != 0) {         //It is unsynchronized. Either take a synchronized list or another collection which supports concurrent modification
                l1.remove();            //It is related to multi-threading concept.
            }                           //Take a new list and add only even numbers from list l1 to it  and print that list.
        }
        System.out.println("l1 : " + l1); */
    }
}
