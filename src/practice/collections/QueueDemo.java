package practice.collections;

import java.util.ArrayDeque;
import java.util.Queue;

public class QueueDemo {
    public static void show() {
        Queue<String> queue = new ArrayDeque<>();
        // queue.add("c");
        // queue.add("a");
        // queue.add("b");     //b -> a -> c
        // queue.offer("d");   //add() and offer() are same for ArrayDeque but with queue implementations with limited size, when full add() throws exception and offer() returns false.

        // var front = queue.peek();
        // var front = queue.element();    //peek() returns null when empty whereas element() throws exception.
        // System.out.println(front);

        // System.out.println(queue.remove());
        System.out.println(queue.poll());   //poll() returns null when empty whereas remove() throws exception.
        System.out.println(queue);
    }
}
