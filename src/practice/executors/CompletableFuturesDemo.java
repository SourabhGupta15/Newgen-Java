package practice.executors;

import java.time.Duration;
import java.time.LocalTime;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;
import java.util.stream.Collectors;

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

    public static int toFahrenheit(int celsius) {
        return (int) ((celsius * 1.8) + 32);
    }

    public static void showTransformingCompletableFutures() {
        // Sometimes we need to transform the result of an Asynchronous Task.

        var future = CompletableFuture.supplyAsync(() -> 20);

        // try {
        //     var result = future
        //                     .thenApply(celsius -> (celsius * 1.8) + 32)       // thenApply() takes a Function object that converts or maps the result of the previous CompletableFuture to a new value. It returns a new CompletableFuture object. thenApplyAsync() is the asynchronous version of this method. It runs on another thread.
        //                     .get();     // get() returns the value from the new CompletableFuture object.
        //     System.out.println(result);
        // } catch (InterruptedException | ExecutionException e) {
        //     e.printStackTrace();
        // }

        future
            .thenApply(CompletableFuturesDemo::toFahrenheit)       // We can use method reference instead of lambda expression.
            .thenAccept(System.out::println);      // Accepts a Consumer object. It is run on main thread. We can use it instead of get and avoid try-catch block. thenAccept() returns CompletableFuture<Void>. If we want to run it on another thread, we can use thenAcceptAsync().
    }

    public static CompletableFuture<String> getUserEmailAsync() {
        return CompletableFuture.supplyAsync(() -> "email");
    }

    public static CompletableFuture<String> getUserPlaylistAsync(String email) {
        return CompletableFuture.supplyAsync(() -> "playlist");
    }

    public static void showComposingCompletableFutures() {
        // Starting a task upon completion of another task.

        // First task  : Get user email using user id       : id -> email
        // Second task : Get user playlist using user email : email -> playlist

        // var future = CompletableFuture.supplyAsync(() -> "email");

        // future
        // CompletableFuture.supplyAsync(() -> "email")     // No need to declare variable future.
        getUserEmailAsync()         // Using a function/method
            // .thenCompose(email -> CompletableFuture.supplyAsync(() -> "playlist"))       // Takes a Function object which maps a String(in this case) to a CompletionStage<Object> object and returns new CompletableFuture object which represents a new asy  nchronous task.
            .thenCompose(CompletableFuturesDemo::getUserPlaylistAsync)
            .thenAccept(System.out::println);
    }

    public static void showCombiningCompletableFutures() {
        // Call a service -> reutrns price in USD -> 20 USD
        // Call another service to get exchange rate in Euro -> 0.9 Euro

        var first = CompletableFuture.supplyAsync(() -> 20);
        var second = CompletableFuture.supplyAsync(() -> 0.9);

        // first
        //     .thenCombine(second, (price, exchangeRate) -> price * exchangeRate)      // With this we can combine the result of two asynchronous operation. So we can wait for both of them to complete to calculate the final result. Calling this method does not block the current thread. Here we pass a CompletionStage object and a BiFunction object. BiFunction is a function that takes 2 parameters and returns a value. The parameters' classes should be the classes of the results of our tasks respectively that is first and second's result here that is 20(Integer) and 0.9(Double). thenCombine() returns a new CompletableFuture object.
        //     .thenAccept(System.out::println);

        var third = CompletableFuture
                        .supplyAsync(() -> "20USD")        // If our first task returned a String
                        .thenApply(str -> {
                            var price = str.replace("USD", "");
                            return Integer.parseInt(price);
                        });

        third
            .thenCombine(second, (price, exchangeRate) -> price * exchangeRate)
            .thenAccept(System.out::println);
    }

    public static void showWaitingForManyTasksToComplete() {
        // Sometimes we need to wait for completion of many tasks to do something else.

        var first = CompletableFuture.supplyAsync(() -> 1);
        var second = CompletableFuture.supplyAsync(() -> 2);
        var third = CompletableFuture.supplyAsync(() -> 3);
        
        var all = CompletableFuture.allOf(first, second, third);     // It takes multiple number of tasks and returns new CompletableFuture<Void> object

        all.thenRun(() -> {
            try {
                System.out.println(first.get());
                System.out.println(second.get());
                System.out.println(third.get());        // Here all tasks work asynchronously and do not block the current thread.
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
            System.out.println("All tasks completed successfully");
        });
    }

    public static void showWaitingForFirstTask() {
        // We have 2 services to get the current weather in a given city. But sometimes one of these responds little bit slower. We call the services concurrently. As soon as we get a response, we display it.

        var first = CompletableFuture.supplyAsync(() -> {
            LongTask.simulate();
            return 20;
        });

        var second = CompletableFuture.supplyAsync(() -> 20);

        CompletableFuture
                .anyOf(first, second)       // Same as allOf() except it returns a new CompletableFuture as soon as any of the tasks passed gets complete.
                .thenAccept(System.out::println);
    }

    public static void showHandlingTimeouts() {
        // We have to set a limit on how long we can wait to get a response. We don't want to wait forever.

        var future = CompletableFuture.supplyAsync(() -> {
            LongTask.simulate();
            return 1;
        });

        // try {
        //     var result = future
        //                 .orTimeout(1, TimeUnit.SECONDS)     // It takes a timeout value and a TimeUnit and returns a new CompletableFuture object. It also throws a TimeOutException if the cuurent task does not complete within the timelimit.
        //                 .get();
        //     System.out.println(result);
        // } catch (InterruptedException | ExecutionException e) {
        //     e.printStackTrace();
        // }

        try {
            var result = future
                        .completeOnTimeout(1, 1, TimeUnit.SECONDS)     // Same as orTimeout() except the first parameter is a Default value in case the current task does not complete within time limit.
                        .get();
            System.out.println(result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    public static void showFlightServices() {
        var start = LocalTime.now();        // To get current time.

        var service = new FilghtService();
        // service
        //     .getQuote("site1")
        //     .thenAccept(System.out::println);

        var futures = service
                        .getQuotes()        // Returns Stream<CompletableFuture<Quote>>
                        .map(future -> future.thenAccept(System.out::println))      // map() takes CompletableFuture<Quote>
                        .collect(Collectors.toList());

        CompletableFuture
            .allOf(futures.toArray(new CompletableFuture[0]))       // We pass an Array of CompletableFuture to get the result in the same format.
            .thenRun(() -> {
                var end = LocalTime.now();
                var duration = Duration.between(start, end);
                System.out.println("Retrieved all quotes in " + duration.toMillis() + " msec");
            });

        try {
            Thread.sleep(10_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
