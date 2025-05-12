package exceptionHandling;

public class SystemExitDemo {
    public static void main(String[] args) {
        try {
            System.out.println("Inside try block");
            System.exit(0);
            throw new Exception("Explicitly throwing an exception.");
        } catch (Exception e) {
            System.out.println("Inside catch block : " + e.getMessage());
        } finally {
            System.out.println("Inside finally block");
        }
    }
}
