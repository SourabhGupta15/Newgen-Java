package practice.executors;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.function.Supplier;

public class CompletableFuturesDemo {
    // Every ComletableFuture object is a Future object as it implements Future interface.
    // With this we can explicitly complete Future object.
    // ComletableFuture class also implements another interface called CompletionStage. This interface represents a step or a stage in an asynchronous operation, and it gives us a bunch of methods for combining and composing these steps in a declarative way. Kind of like how we use the streams api to build a complex query in a declarartive way. Earlier we used the map, filter and reduce methods to build a complex query. Now we can do the same thing with this CompletionStage interface.

    public static void show() {
        // Runnable task = () -> System.out.println("a");

        // ForkJoinPool.commonPool();      // It reutrns pool that is used by CompletableFuture class. So if we don't supply pool/Executor in runAsync(), then this is the pool that is going to be used under the hood. Common pool is based on the number of available threads.
 
        // var future = CompletableFuture.runAsync(task);       // If we want to run a task that doesn't return a value we use runAsync() and pass Runnable Object or Runnable Object plus an Executor. If we don't pass an Executor, this method will run task on a common pool. We this single line of code, we can execute the task in an asynchronous fashion. We don't have to create an Executor, then submit a task to it ans then shut it down.

        Supplier<Integer> task1 = () -> 1;

        var future1 = CompletableFuture.supplyAsync(task1);      // We use it if we want our task to return a value. We have to pass a Supplier object instead of Runnable object. Similar to runAsync(). If we don't supply an executor, common pool will be used.

        try {
            var result = future1.get();
            System.out.println(result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    public static void showRunningCodeOnCompletion() {
        // Quite often we need to execute code when an asynchronous operation completes.

        var future = CompletableFuture.supplyAsync(() -> 1);
        // future.thenRun(() -> {
        //     System.out.println(Thread.currentThread().getName());
        //     System.out.println("Done");
        // });   // this method is provided by CompletionStage interface. We need to pass a Runnable object. It is run on main thread.

        // future.thenRunAsync(() -> {
        //     System.out.println(Thread.currentThread().getName());
        //     System.out.println("Done");
        // });       // It is like runAsync(). It is run on another thread.

        // future.thenAccept(result -> {
        //     System.out.println(Thread.currentThread().getName());
        //     System.out.println(result);
        // });    // It is useful when we want to get the result of this CompletableFuture. We should pass a Consumer object. It is run on main thread.

        future.thenAcceptAsync(result -> {
            System.out.println(Thread.currentThread().getName());
            System.out.println(result);
        });     // Runs on another thread.

        try {
            Thread.sleep(2000);     // To display result from above.
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void showHandlingExceptions() {
        // What if we want to consume a result from an asynchronous task and the task throws an exception.

        var future = CompletableFuture.supplyAsync(() -> {
            System.out.println("Getting the current weather");
            throw new IllegalStateException();      // This exception is thrown on a different thread so we don't see anything.
        });

        try {
            // future.get();       // To display the exception thrown above
            var temperature = future.exceptionally(excep -> 1).get();       // exceptionally() takes a Function object that maps a Throwable object to different type. Here we map exception to numeric value 1. exceptionally() returns a new CompletableFuture object. So get() method returns value from this new CompletableFuture object.
            System.out.println(temperature);
        } catch (InterruptedException | ExecutionException e) {
            System.out.println(e.getCause());       // To get the actual exception.
            e.printStackTrace();
        }
    }
}
