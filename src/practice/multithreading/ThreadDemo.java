package practice.multithreading;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ThreadDemo {
    public static void show() {
        System.out.println(Thread.currentThread().getName());
        // System.out.println(Thread.currentThread().getId());     // Each thread has a name and an ID.

        for (var i = 0; i < 10; i++) {
            Thread thread = new Thread(new DownloadFileTask());
            thread.start();
        }
    }

    public static void showJoining() {
        Thread thread = new Thread(new DownloadFileTask());
        thread.start();

        try {
            thread.join();      // join() tells the current thread to wait for the completion of another thread.
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("File is ready to be scanned.");
    }

    public static void showInterrupting() {
        Thread thread = new Thread(new DownloadFileTask());
        thread.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {      // If the thread is sleeping and we send an interrupt request to it, then it throws an exception. That is why we need to write sleep() in a try-catch block and handle the InterruptedException.
            e.printStackTrace();
        }

        thread.interrupt();         // interrupt() doesn't force a thread to stop what it's doing, it simply sends an interrupt request. It's upto the thread to decide to stop what it is doing.
    }

    public static void showConcurrencyIssues() {
        // 1. Race Condition.
        // 2. Visibility Problem : When one thread changes the shared data, but the changes are not visible to other threads. So different threads hav different views of the shared data.
    }

    public static void showRaceConditions() {
        // Multiple threads are racing or competing to modify some data.
        // If multiple threads try to change the same data, we may get wrong results or the application may crash. This is known as Race Condition.

        var status = new DownloadStatus();

        List<Thread> threads = new ArrayList<>();

        for (var i = 0; i < 10; i++) {
            var thread = new Thread(new DownloadFileTask(status));
            thread.start();
            threads.add(thread);
        }

        for (var thread : threads)
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        System.out.println(status.getTotalBytes());     // We should get the output 10,000 but instead we get very less value than that. It is because the increment step in DownloadStatus is non-atomic operation. Multiple threads access the totalBytes value at same time before completion of increment operation. So they store the same value before another thread has completed incrementing.
    }

    public static void showStrategiesForThreadSafety() {
        // Confinement : Not to share data across threads in the first place. We want to confine or restrict each thread have its own data.

        // Immutability : To use immutable or unchangable objects.

        // Synchronization : To prevent multiple threads from accessing the same objects concurrently. We synchronize or co-ordinate the access to an object across different threads. We do that using locks.
        // Synchroniztion forces the code to run sequentially which is against the idea of concurrency. Implementing synchroniztion is challenging and error-prone.
        // One of the problems is Deadlock which happens when two threads wait for each other indefinitely. So thread1 and thread2 wait for each other simultaneously. It can cause our application to crash.
        // We should avoid synchronization as much as possible.

        // Atomic Objects : To use atomic classes in Java such as AtomicInteger. This classes allow us to achieve thread-safety without using locks. If we increment an atomic integer, the JVM will execute the increment operation as one single atomic operation.

        // Partitioning : Partitioning data into segments that can be accessed concurrently. Java provides a number of collection classes to support concurrency using partitioning.
    }

    public static void showConfinement() {
        List<Thread> threads = new ArrayList<>();
        List<DownloadFileTask> tasks = new ArrayList<>();

        for (var i = 0; i < 10; i++) {
            var task = new DownloadFileTask();
            tasks.add(task);

            var thread = new Thread(task);
            thread.start();
            threads.add(thread);
        }

        for (var thread : threads)
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        var totalBytes = tasks.stream()
                                .map(task -> task.getStatus().getTotalBytes())      // returns stream of totalBytes for each task in tasks.
                                .reduce(Integer::sum);      // adds all the totalBytes of each task.
        System.out.println(totalBytes);
    }

    public static void showLocks() {
        // We put a lock on certain parts of our code and only one thread at a time can execute that part. Other threads have to wait.
        // The blocks of code on which we put lock are called Critical Section.

        var status = new DownloadStatus();

        List<Thread> threads = new ArrayList<>();

        for (var i = 0; i < 10; i++) {
            var thread = new Thread(new DownloadFileTask(status));
            thread.start();
            threads.add(thread);
        }

        for (var thread : threads)
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        System.out.println(status.getTotalBytes());
    }

    public static void showSynchronized() {
        var status = new DownloadStatus();

        List<Thread> threads = new ArrayList<>();

        for (var i = 0; i < 10; i++) {
            var thread = new Thread(new DownloadFileTask(status));
            thread.start();
            threads.add(thread);
        }

        for (var thread : threads)
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        System.out.println(status.getTotalBytes());
    }

    public static void showVolatile() {
        // Volatile Keyword solves the visibility problem but not the race condition. So it doesn't prevent 2 threads simultaneously modifying some data instead it ensures that if one thread modifies some data, other threads can see the changes.

        var status = new DownloadStatus();
        
        var thread1 = new Thread(new DownloadFileTask(status));
        var thread2 = new Thread(() -> {
            while (!status.isDone()) {}
            System.out.println(status.getTotalBytes());
        });

        thread1.start();
        thread2.start();
    }

    public static void showSignalling() {
        //  Sometimes we want the thread to wait until some condition becomes true otherwise it wastes CPU cycles.

        var status = new DownloadStatus();
        
        var thread1 = new Thread(new DownloadFileTask(status));
        var thread2 = new Thread(() -> {
            while (!status.isDone()) {
                synchronized (status) {
                    try {
                        status.wait();      // It makes the thread go to sleep until another thread notifies the thread the state of the status object is changed. So the while loop will not run million times. wait() will put it into sleep until another thread wakes it up. The JVM expects us to call the wait() inside a synchronized block.
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            System.out.println(status.getTotalBytes());
        });

        thread1.start();
        thread2.start();
    }

    public static void showAtomicObjects() {
        // Atomic types use a technique called 'compare and swap' which is supported by most CPUs.
        // Aromic Objects are great for implementing counters.
        var status = new DownloadStatus();

        List<Thread> threads = new ArrayList<>();

        for (var i = 0; i < 10; i++) {
            var thread = new Thread(new DownloadFileTask(status));
            thread.start();
            threads.add(thread);
        }

        for (var thread : threads)
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        System.out.println(status.getTotalAtomicBytes());
    }

    public static void showAdders() {
        // If we have multiple threads updating a value frequently, its better to used Adder classes in Java. They are faster than atomic types.
        // Internally Adder objects keep an array of counters that can grow on demand. So we don;t have a single place in memory where value is stored. We have a bunch of array cells each holding a counter value. So different threads can modify these counter variables concurrently. That's why Adder classes are faster than Atomic types beacuse they allow more throughput.

        var status = new DownloadStatus();

        List<Thread> threads = new ArrayList<>();

        for (var i = 0; i < 10; i++) {
            var thread = new Thread(new DownloadFileTask(status));
            thread.start();
            threads.add(thread);
        }

        for (var thread : threads)
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        System.out.println(status.getTotalAdderBytes());
    }

    public static void showSynchronizedCollections() {
        // Sometimes we need to share collection across many threads.
        // Synchronized Collections achieve thread safety by using locks. So when a thread gets access to synchronized collection, the entire collection gets locked and other threads have to wait. This works well for most cases but it can have negative impact on performance and scalability as the number of threads and concurrent operations increase.

        Collection<Integer> collection = Collections.synchronizedCollection(new ArrayList<>());

        var thread1 = new Thread(() -> {
            collection.addAll(Arrays.asList(1,2,3));
        });

        var thread2 = new Thread(() -> {
            collection.addAll(Arrays.asList(4,5,6));
        });

        var thread3 = new Thread(() -> {
            collection.addAll(Arrays.asList(7,8,9));
        });

        thread1.start();
        thread2.start();
        thread3.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(collection);
    }

    public static void showConcurrentCOllections() {
        // This collections use partitioning techniques to allow concurrency. So they divide the data into segments and different threads can concurrently work with differnt segments. But only one thread at a time can access a given segment. So Concurrent collections sre faster than Synchronized collections because they don't use synchronization.
        // They are declared in java.util.concurrent package

        Map<Integer, String> map = new ConcurrentHashMap<>();
        map.put(1, "a");
        map.get(1);
        map.remove(1);
    }
}
