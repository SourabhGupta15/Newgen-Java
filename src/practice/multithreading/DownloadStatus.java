package practice.multithreading;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAdder;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DownloadStatus {
    private int totalBytes;
    private int totalFiles;
    private volatile boolean isDone;        // volatile means unstable. We are telling the JVM that this field is unstable and it may change. So don't rely on the value stored in the cache. Always read it from the main memory. And that means if another thread updates the value of this field, the change will be immediately written to the main memory.

    private AtomicInteger totalAtomicBytes = new AtomicInteger();
    private LongAdder totalAdderBytes = new LongAdder();

    private Lock lock = new ReentrantLock();
    
    private Object totalBytesLock = new Object();
    private Object totalFilesLock = new Object();
    

    public int getTotalFiles() {
        return totalFiles;
    }

    public int getTotalBytes() {
        return totalBytes;
    }
    
    public boolean isDone() {
        return isDone;
    }

    public void done() {
        isDone = true;
    }

    public int getTotalAtomicBytes() {
        return totalAtomicBytes.get();
    }
    
     public void incrementTotalAtomicBytes() {
        totalAtomicBytes.incrementAndGet();     // It is pre increment. For post increment use getAndIncrement().
     }

     public int getTotalAdderBytes() {
        return totalAdderBytes.intValue();      // Internally it calls sum() which adds upa all the counter values and return the result.
    }
    
     public void incrementTotalAdderBytes() {
        totalAdderBytes.increment();
     }

    public void incrementTotalBytes() {
        totalBytes++;       // This line gets executed in 3 steps. First, the value of this field will be read from the main memory and stored in the CPU. Next, the CPU is going to increment this value and then the updated value is going to be stored in the memory. So, this are 3 steps. This is called a non-atomic operation because it involves multipe steps. In contrast, an atomic operation is like an atom, it cannot be breaken down into multiple steps.
    }

     public void incrementTotalBytesUsingLock() {
        lock.lock();
        try {
            totalBytes++;
        }
        finally {
            lock.unlock();      // As a best practice we should execute unlock() in a finally block because if an exception is thrown, we don't wanna keep this lock locked forever, otherwise no other threads could execute this code and this may cause a deadlock and our application will crash. In this particular case we don't need try-finally block because incrementing the totalBytes field will not cause an axception. But in other applications with more complex logic somewhere along that logic we might get an exception.
        }
     }

     public void incrementTotalBytesUsingSynchronized() {
        synchronized (totalBytesLock) {       // In () we should pass an object called monitor object. Every object in Java has a built-in lock. So Java is gonna get the built-in lock from the object and use it under the hood. We can pass 'this' as a reference to current object but it is a bad practice as only one thread at a time can call into synchronized block of this object. With the implementation using 'this', if one thread is calling incrementTotalFilesUsingSynchronized() then another thread cannot call incrementTotalBytesUsingSynchronized() beacuse both are using same monitor object 'this' that is current object. The whole point of synchronization is that 2 threads cannot modify the same data at same time. But here we are dealing with 2 different fields. So using the same monitor object reduces the throughput of this class. It can cause unnecessary waits. It simple application with few threads it may not cause a problem, but in larger application with more concurrency requirements we us dedicated monitor objects.
            totalBytes++;
        }
    }

    public void incrementTotalFilesUsingSynchronized() {
        synchronized (totalFilesLock)  {
            totalFiles++;
        }
    }

    public synchronized void incrementTotalBytesUsingSynchronizedMethod() {     // The synchronized keyword here is like using synchronized(this). So it uses current object. So it is better to use a synchronized() {} block with dedicate monitor object.
        totalBytes++;
    }
}
