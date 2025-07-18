package practice.executors;

import java.util.concurrent.CompletableFuture;

public class MailService {
    public void send() {            // Synchronous method
        LongTask.simulate();
        System.out.println("Mail was sent");
    }

    public CompletableFuture<Void> sendAsync() {        // Asynchronous version of send()
        return CompletableFuture.runAsync(() -> send());        // In runAsync() we need to pass a Runnable object, so we pass the above method which is synchronous. When we call this runAsync(), it is going to be executed on another thread in common thread pool.
    }
}
