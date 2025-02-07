package multithreading;

public class ThreadExample {
    public static void main(String[] args) {    // main thread
        
        // MyThread t1 = new MyThread();   // new separate thread created
        // MyThread t2 = new MyThread("ABC");  // another way to add name using constructor
        // t1.setName("XYZ");  // setting name for thread
        // t1.start(); // new separate thread starts running
        // t2.start();
        
        // try {
        //     Thread.sleep(2000);     // puts main method thread in sleep
        // } catch (InterruptedException e) {
        //     throw new RuntimeException(e);
        // }

        // System.out.println("t1.getName() : " + t1.getName());   // Sometimes this gets printed before the line in run() method because this is a part of main thread and run() is a part of new separate thread and these both thread executes simultaneously.
        

        ThreadWithRunnable threadWithRunnable = new ThreadWithRunnable();
        Thread t3 = new Thread(threadWithRunnable);
        Thread t4 = new Thread(threadWithRunnable, "t-4");
        t3.setName("t-3");
        t3.start();
        t4.start();
    }
}
