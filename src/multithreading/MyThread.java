package multithreading;

public class MyThread extends Thread {
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + " is running!");  // getName() is a non-static method, so it cannot be applied directly to class and currentThread() returns the reference of the cuurent thread object.
        }
    }

    public MyThread() {}    // Default constructor

    public MyThread(String name) {  // Constructor to set name to thread
        super(name);
    }
}
