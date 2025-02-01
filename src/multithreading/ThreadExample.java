package multithreading;

public class ThreadExample {
    public static void main(String[] args) {    // main thread
        
        MyThread t1 = new MyThread();   // new separate thread created
        t1.start(); // new separate thread starts running
        t1.setName("XYZ");  // setting name for thread
        
        // try {
        //     Thread.sleep(2000);     // puts main method thread in sleep
        // } catch (InterruptedException e) {
        //     throw new RuntimeException(e);
        // }

        System.out.println("t1.getName() : " + t1.getName());   // Sometimes this gets printed before the line in run() method because this is a part of main thread and run() is a part of new separate thread and these both thread executes simultaneously.
        
        // MyThread t2 = new MyThread("ABC");  // another way to add name using constructor
        // t2.start();
    }
}
