package exceptionHandling;

public class NegativeNumberException extends RuntimeException {
    
    public NegativeNumberException() {}

    public NegativeNumberException(String message) {
        super(message);     // super() method calls the parent class(RuntimeException) of the current class(NegativeNumberException) and passes the argument(message) from child class constructor to the same argument declared in the parent class constructor.
    }
}
