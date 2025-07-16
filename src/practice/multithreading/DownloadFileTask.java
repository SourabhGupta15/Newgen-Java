package practice.multithreading;

public class DownloadFileTask implements Runnable {
    private DownloadStatus status;

    public DownloadFileTask() {
        this.status = new DownloadStatus();
    }

    public DownloadFileTask(DownloadStatus status) {
        this.status = status;
    }

    @Override
    public void run() {
        System.out.println("Downloading a file : " + Thread.currentThread().getName());

        // try {
        //     Thread.sleep(5000);         // Pausing a thread
        // } catch (InterruptedException e) {
        //     e.printStackTrace();
        // }

        for (var i = 0; i < 10_000; i++) {
            if (Thread.currentThread().isInterrupted()) return;     // If we don't write this line of code, then the thread won't stop if interrupted.
            // System.out.println("Downloading byte " + i);
            // status.incrementTotalBytes();
            // status.incrementTotalBytesUsingLock();
            // status.incrementTotalBytesUsingSynchronized();
            // status.incrementTotalBytesUsingSynchronizedMethod();
            // status.incrementTotalAtomicBytes();
            status.incrementTotalAdderBytes();
        }

        status.done();

        synchronized (status) {
            status.notify();        // notifyAll() is usefule if there are multiple threads waiting on change of this object. We need to wrap notify() and notifyAll() in synchronized block otherwise it throws RuntimeException.
        }

        System.out.println("Download Complete : " + Thread.currentThread().getName());
    }

    public DownloadStatus getStatus() {
        return status;
    }
}
