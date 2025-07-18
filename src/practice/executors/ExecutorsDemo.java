package practice.executors;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

public class ExecutorsDemo {
    public static void show() {
        var executor = Executors.newFixedThreadPool(2);     //returns ExecutorService interface object. But at runtime changes to a Executor child class. For eg. here it returns ThreaadPoolExecutor. Check below.
        // System.out.println(executor.getClass().getName());

        // for (var i = 0; i < 10; i++)
        //     executor.submit(() -> {
            //             System.out.println(Thread.currentThread().getName());
            //     });         // When we start an executor and submit our task, the executor thinks there might be more tasks coming in the future. So it's not going to terminate, it's going to stay in the memory waiting for new tasks. So we have to explicitly shutdown an executor to terminate our program.

        try {
            executor.submit(() -> System.out.println(Thread.currentThread().getName()));        // Here submit takes Runnable object.
        }
        finally {
            executor.shutdown();        // it waits for the completion of tasks, but it's not going to accept any new tasks. We should always write shutdown() in a finally block because if any exception is thrown in between submit() and shutdown(), the executor will not terminate. Writing it in finally block ensures no matter what, we always shutdown an executor and release it from memory.

            // executor.shutdownNow();     // it forces the existing tasks to stop.

            // Executor framework does not protect us from concurrency issues. It just simplifies thread manipulation.
        }
    }

    public static void showCallablesAndFutures() {
        // Sometimes we want to return a value from a task. For eg. we may call the Twitter API to get the latest tweets for a given user. That's when we use the Callable Interface.
        // Callable Interface represents a task that returns a value

        var executor = Executors.newFixedThreadPool(2);

        try {
            var future = executor.submit(() -> {
                                LongTask.simulate();
                                return 1;
                         });        // Here submit() takes a Callable object and returns a Future<Integer> object. Future is an interface that represents the future result of an operation. An operation that will complete in the future.

            System.out.println("Do more work");

            try {
                var result = future.get();      // get() returns value stored in future. It is a blocking method. When we call this method, the current thread has to wait until the result of this method is ready.
                System.out.println(result);
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        finally {
            executor.shutdown();
        }
    }
    
    public static void showAsynchronousProgramming() {
        // To get the most of our threads we must write code in a non-blocking way. That is what we call Asynchronous Programming.
    }
}
