package practice.executors;

public class Main {
    public static void main(String[] args) {
        // ExecutorsDemo.show();
        // ExecutorsDemo.showCallablesAndFutures();
        
        // CompletableFuturesDemo.show();

        // var service = new MailService();
        // // service.send();         // Synchronous or blocking method.
        
        // service.sendAsync();        // Here we have command-line program, and this program terminates so quickly that we don't see the result of this task that was executed on a separate thread. We don't have this problem on a mobile or a desktop app, because these apps are continuously running until the user terminates them.

        // System.out.println("Hello World");

        // try {
        //     Thread.sleep(5000);     //to see the result of sendAsync()
        // } catch (InterruptedException e) {
        //     e.printStackTrace();
        // }

        // CompletableFuturesDemo.showRunningCodeOnCompletion();
        // CompletableFuturesDemo.showHandlingExceptions();
        // CompletableFuturesDemo.showTransformingCompletableFutures();
        // CompletableFuturesDemo.showComposingCompletableFutures();
        // CompletableFuturesDemo.showCombiningCompletableFutures();
        // CompletableFuturesDemo.showWaitingForManyTasksToComplete();
        // CompletableFuturesDemo.showWaitingForFirstTask();
        // CompletableFuturesDemo.showHandlingTimeouts();
        CompletableFuturesDemo.showFlightServices();
    }
}
